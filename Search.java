public class Search {
    public boolean binarySearchInRange(int[] array, int value, int left, int right) {
        if (array == null || left < 0 || right >= array.length || left > right) {
            throw new IllegalArgumentException("Invalid input parameters.");
        }

        // Verify if the array is sorted in the specified range
        for (int i = left; i < right; i++) {
            if (array[i] > array[i + 1]) {
                throw new IllegalArgumentException("Array is not sorted in the specified range.");
            }
        }

        // Perform non-recursive binary search
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == value) {
                return true;
            }
            if (array[mid] < value) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
