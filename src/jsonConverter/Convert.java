package jsonConverter;

import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Convert {

    public String convertToJson(Object object) {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{\n");

        Field[] objectFields = object.getClass().getDeclaredFields();

        for (int i = 0; i < objectFields.length; i++) {
            objectFields[i].setAccessible(true);
            String fieldName = objectFields[i].getName();
            Object fieldValue = null;

            try {
                fieldValue = objectFields[i].get(object);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

            jsonBuilder.append("\t\"")
                    .append(fieldName)
                    .append("\":");

            if (fieldValue == null) {
                jsonBuilder.append("null");

            } else if (fieldValue instanceof String) {
                jsonBuilder.append("\"")
                        .append(fieldValue)
                        .append("\"");

            } else if (isPrimitiveOrWrapper(fieldValue.getClass())) {
                jsonBuilder.append(fieldValue);

            } else if (fieldValue instanceof List) {
                Object[] objects = ((List<?>) fieldValue).toArray();
                jsonBuilder.append("[\n");

                for (int j = 0; j < objects.length; j++) {
                    if (objects[j] instanceof String) {
                        jsonBuilder.append("\t\t\"")
                                .append(objects[j])
                                .append("\"");
                        if (j < objects.length - 1) {
                            jsonBuilder.append(",\n");
                        }
                    } else {
                        jsonBuilder.append(convertToJson(objects[j]));
                    }
                }
                jsonBuilder.append("\n\t]");

            } else if (fieldValue instanceof Map) {
                Set<? extends Map.Entry<?, ?>> mapValues = ((Map<?, ?>) fieldValue).entrySet();
                Iterator<? extends Map.Entry<?, ?>> mapIterator = mapValues.iterator();
                jsonBuilder.append("{\n");

                for (int j = 0; j < mapValues.size(); j++) {
                    Map.Entry<?, ?> next = mapIterator.next();
                    if (next.getValue() instanceof String) {
                        jsonBuilder.append("\t\t\"")
                                .append(next.getKey().toString())
                                .append("\":\"")
                                .append(next.getValue().toString())
                                .append("\"");
                        if (j < mapValues.size()) {
                            jsonBuilder.append(",\n");
                        }
                    } else {
                        jsonBuilder.append(convertToJson(next.getValue()));
                    }
                    jsonBuilder.append("\t\t\"")
                            .append(next.getKey())
                            .append("\":\"")
                            .append(next.getValue())
                            .append("\"");
                    if (j < mapValues.size()) {
                        jsonBuilder.append(",\n");
                    }
                }
                jsonBuilder.append("\t}");

            } else if (fieldValue instanceof Set) {
                jsonBuilder.append("[\n");
                Object[] setArray = ((Set<?>) fieldValue).toArray();
                for (int j = 0; j < setArray.length; j++) {
                    if (setArray[j] instanceof String) {
                        jsonBuilder.append("\t\t\"")
                                .append(setArray[j])
                                .append("\"");
                        if (j < setArray.length - 1) {
                            jsonBuilder.append(",\n");
                        }
                    } else {
                        jsonBuilder.append(convertToJson(setArray[j]));
                    }
                }
                jsonBuilder.append("\n\t]");
            } else {
                jsonBuilder.append(convertToJson(fieldValue));
            }
            if (i < objectFields.length - 1) {
                jsonBuilder.append(",\n");
            }
        }

        jsonBuilder.append("\n}");
        return jsonBuilder.toString();
    }

    private boolean isPrimitiveOrWrapper(Class<?> type) {
        return type.isPrimitive()
                || type == String.class
                || type == Integer.class
                || type == Double.class
                || type == Long.class
                || type == Boolean.class;
    }
}
