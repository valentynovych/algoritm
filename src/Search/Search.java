package Search;

public class Search {
    public static void binarySearch(int[] inputArray, int elemToSearch) {
        int firstIndex = 0;
        int lastIndex = inputArray.length - 1;

        int count = 1;
        int middle = 0;
        while (inputArray[middle] != elemToSearch && firstIndex <= lastIndex) {
            count++;
            middle = (firstIndex + lastIndex) / 2;

            if (inputArray[middle] > elemToSearch) {
                lastIndex = middle - 1;
            } else {
                firstIndex = middle + 1;
            }
        }

        if (inputArray[middle] == elemToSearch) {
            System.out.println("Element - " + elemToSearch + " on the position: " + ++middle);
            System.out.println("Iterations performed: " + count);
        } else {
            System.out.println("Elem - " + elemToSearch + " not exist on array. Iterations passed: " + count);
        }
    }

    public static void quickSort(int[] inputArray, int firstIndex, int lastIndex) {

        if (inputArray.length == 0 || firstIndex >= lastIndex) {
            return;
        }

        int pivot = inputArray[((firstIndex + lastIndex) / 2)];

        int leftMarker = firstIndex;
        int rightMarker = lastIndex;

        while (leftMarker <= rightMarker) {

            while (inputArray[leftMarker] < pivot) leftMarker++;

            while (inputArray[rightMarker] > pivot) rightMarker--;

            if (leftMarker <= rightMarker) {
                int tmp = inputArray[leftMarker];
                inputArray[leftMarker] = inputArray[rightMarker];
                inputArray[rightMarker] = tmp;
                leftMarker++;
                rightMarker--;
            }
        }

        if (firstIndex < rightMarker) {
            quickSort(inputArray, firstIndex, rightMarker);
        }

        if (lastIndex > leftMarker) {
            quickSort(inputArray, leftMarker, lastIndex);
        }
    }
}
