package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
	
//	public int[][] divideArray(int[] array, int groupSize) {
//		
//		int numberOfGroups = (int)Math.ceil((double)array.length / groupSize);
//		
//		int[][] output = new int[numberOfGroups][];
//		
//		for(int i = 0; i < numberOfGroups; i++) {
//			int a = i * groupSize;
//			int length = Math.min(array.length - a, groupSize);
//			
//			int[] temp = new int[length];
//			
//			System.arraycopy(array, a, temp, 0, length);
//			
//			output[i] = temp;
//			
//		}
//		
//		return output;
//	}
//	
//	public int[] insertionSort(int[] array) {
//		
//		int key;
//		int j;
//		
//		for(int i = 0; i < array.length; i++) {
//			
//			key = array[i];
//			
//			for(j = i - 1; (i >= 0) && (array[j] < key); j--) {
//				array[j + 1] = array[j];
//			}
//			
//			array[j + 1] = key;
//		}
//		
//		return array;
//	}
//	
//	public double findMedian(int[] array) {
//		
//		double median;
//		
//		if (array.length % 2 == 0)
//		    median = ((double)array[array.length/2] + (double)array[array.length/2 - 1])/2;
//		else
//		    median = (double)array[array.length/2];
//		
//		return median;
//	}
//	
//	public int quickSelect(int[] array, int k) {
//		
//		int kthSmallestElement;
//		int[][] dividedArrays = divideArray(array, 5);
//		int numberOfGroups = (int)Math.ceil((double)array.length / 5);
//		double[] medians = new double[numberOfGroups];
//		
//		for(int i = 0; i < numberOfGroups; i++) {
//			dividedArrays[i] = insertionSort(dividedArrays[i]); // small arrays are sorted now
//			medians[i] = findMedian(dividedArrays[i]); // medians are collected from small arrays
//		}
//		
//		return kthSmallestElement;
//	}
	
//	public int quickSelect(int[] array, int k) {
//		
//		if(array.length < 10) {
//			array = insertionSort(array);
//			return array[k];
//		}
//		
//		ArrayList<Integer> medians = new ArrayList<Integer>();
//		
//		System.out.println("recursive call");
//		
//		for (int i = 0; i < array.length - array.length % 5; i += 5) {
//			medians.add(getMedian(arr.subList(i, i + 5)));
//			System.out.println(medians.size());
//		}
//		
//		int a = getMedian(medians);
//		
//		//int[] medians = new int[array.length % 5];
//		
//		int index = 0;
//		
////		for(int i = 0; i < array.length - array.length % 5; i += 5) {
////			int[] subArray = Arrays.copyOfRange(array, i, i + 5);
////			medians[index] = findMedian(subArray);
////			index++;
////			System.out.println(Arrays.toString(medians));
////			
////		}
//		
//		//int a = findMedian(medians);
//		
//		int[] left = partition(array, a, true);
//		int[] right = partition(array, a, false);
//		
//		return (left.length + 1 == k) ? a :
//			   (left.length > k) ? quickSelect(left, k) :
//			   quickSelect(right, k - left.length);
//		
//	}
//	
//	public int findMedian(int[] array) {
//		array = insertionSort(array);
//		
//		ArrayList<Integer> arr = new ArrayList<Integer>();
//		for(int i = 0; i < array.length; i++) {
//			arr.add(array[i]);
//		}
//		
//		return array[array.length / 2];
//	}
//	
//	public int[] insertionSort(int[] array) {
//		int temp;
//		for (int i = 1; i < array.length; i++) {
//            for(int j = i ; j > 0 ; j--){
//                if(array[j] < array[j - 1]){
//                    temp = array[j];
//                    array[j] = array[j - 1];
//                    array[j - 1] = temp;
//                }
//            }
//        }
//		return array;
//	}
//	public int[] partition(int[] array, int a, boolean isSmaller) {
//		
//		ArrayList<Integer> arrayList = new ArrayList<Integer>(array.length);
//		ArrayList<Integer> temp = new ArrayList<Integer>();
//		
//		for (int i = 0; i < array.length; i++)
//		  arrayList.add(Integer.valueOf(array[i]));
//		
//		//int[] temp = new int[100];
//		for(int i : arrayList) {
//			if(isSmaller && i < a){
//				temp.add(i);
//			}
//			else if(!isSmaller && i >= a){
//				temp.add(i);
//			}
//		}
//		
//		int[] temp2 = new int[temp.size()];
//		for(int i = 0; i < temp2.length; i++){
//			temp2[i] = temp.get(i);
//		}
//		return temp2;
//	}
//
//		 public int getMedian(List<Integer> a) {
//		  Collections.sort(a);
//		  return a.get(a.size() / 2);
//		 }
	
	public List<Integer> insertionSort(List<Integer> array) {
		
		for(int i = 1; i < array.size(); i++) {
            int key = array.get(i);
            for(int j = i - 1; j >= 0; j--) {
                if(key < array.get(j)) {
                    array.set(j + 1, array.get(j));
                    if(j == 0) {
                        array.set(0, key);
                    }
                } 
                else {
                    array.set(j + 1, key);
                    break;
                }
            }
        }
		return array;
	}
	
	public int quickSelect(List<Integer> array, int k) {
		if (array.size() < 10) { // no need to partition array if size is < 10
			array = insertionSort(array);
			return array.get(k);
		}
		ArrayList<Integer> medians = new ArrayList<Integer>();
		for (int i = 0; i < array.size() - array.size() % 5; i += 5)
			medians.add(findMedian(array.subList(i, i + 5))); // sub groups of 5
		int a = findMedian(medians); // find medians

		ArrayList<Integer> left = getPartition(array, a, true);
		ArrayList<Integer> right = getPartition(array, a, false);

		return (left.size() + 1 == k) ? a : 
			   (left.size() > k) ? 
			    quickSelect(left, k) : 
			    quickSelect(right, k - left.size());
			    // look at partitions recursively
	}

	public int findMedian(List<Integer> array) {
		array = insertionSort(array);
		return array.get(array.size() / 2);
	}

	public ArrayList<Integer> getPartition(List<Integer> array, int a, boolean isSmaller) {
		ArrayList<Integer> temp = new ArrayList<Integer>();
		for (int i : array)
			if (isSmaller && i < a)
				temp.add(i);
			else if (!isSmaller && i >= a)
				temp.add(i);
		return temp;
	}
		

	public static void main(String[] args) {
		
		Main m = new Main();
		
		Random r = new Random();
		
		List<Integer> array = Arrays.asList(88, 30, 11, 17, 22, 16, 39, 8, 31, 55,
			    29, 63, 77, 69, 99, 90, 81, 2, 20, 53, 62, 5, 88, 33, 44, 6);
		
		List<Integer> randomArray = new ArrayList<Integer>();
		
		for(int i = 0; i < 1000; i++) {
			randomArray.add(r.nextInt(100));
		}
//			  System.out.println(m.findKthElement(a, 18));
			  //Collections.sort(a);
			  //System.out.println(a);
			  //System.out.println(a.get(18));
		
//		int[] array = {88, 30, 11, 17, 22, 16, 39, 8, 31, 55,
//			    29, 63, 77, 69, 99, 90, 81, 2, 20, 53, 62, 5, 88, 33, 44, 6};
		
		long startTime = System.nanoTime();
		
		System.out.println(m.quickSelect(randomArray, 5));
		
		long estimatedTime = System.nanoTime() - startTime;
		
		System.out.println(estimatedTime / 1000000.0);

	}

}