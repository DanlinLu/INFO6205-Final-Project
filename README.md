# INFO6205-Final-Project
## 0. paper, report and sorted Chinese results
### paper:
INFO6205-Final-Project/paper/Literature Survey on Radix Sort.pdf
### report:
INFO6205-Final-Project/report/Final Report.pdf
### results:
#### 1. MSD:
1000 Chinese: INFO6205-Final-Project/INFO6205/SortedResultOfMSD-1000.txt
1M Chinese: INFO6205-Final-Project/INFO6205/SortedResultOfMSD.txt
#### 2. LSD:
1000 Chinese: INFO6205-Final-Project/INFO6205/SortedResultOfLSD-1000.txt
1M Chinese: INFO6205-Final-Project/INFO6205/SortedResultOfLSD.txt
#### 3. Tim sort:
1000 Chinese: INFO6205-Final-Project/INFO6205/SortedResultOfTimSort-1000.txt
1M Chinese: INFO6205-Final-Project/INFO6205/SortedResultOfTimSort.txt
#### 4. Dual-Pivot quick sort:
1000 Chinese: INFO6205-Final-Project/INFO6205/SortedResultOfQuickSort_DualPivot-1000.txt
1M Chinese: INFO6205-Final-Project/INFO6205/SortedResultOfQuickSort_DualPivot.txt
#### 5. Husky sort:
1000 Chinese: INFO6205-Final-Project/INFO6205/SortedResultOfHusky-1000.txt
1M Chinese: INFO6205-Final-Project/INFO6205/SortedResultOfHusky.txt
## 1. Converting Chinese to Pinyin
### convertion class:
INFO6205/src/main/java/edu/neu/coe/info6205/finalProject/convertToPinyin.java
### read file class:
INFO6205/src/main/java/edu/neu/coe/info6205/finalProject/readFile.java
### write file class:
INFO6205/src/main/java/edu/neu/coe/info6205/finalProject/WriteFile.java
## 2. MSD radix sort
### algorithm:
INFO6205/src/main/java/edu/neu/coe/info6205/sort/counting/MSDStringSort.java
### unit test:
INFO6205/src/test/java/edu/neu/coe/info6205/sort/counting/MSDStringSortTest.java
### output:
INFO6205/src/main/java/edu/neu/coe/info6205/finalProject/MSDOutput.java
### benchmark result:
INFO6205/src/main/java/edu/neu/coe/info6205/finalProject/MSDResult.java
## 3. LSD radix sort
### algorithm:
INFO6205/src/main/java/edu/neu/coe/info6205/sort/counting/LSDStringSort.java
### unit test:
INFO6205/src/test/java/edu/neu/coe/info6205/sort/counting/LSDStringSortTestRunner.java
### output:
INFO6205/src/main/java/edu/neu/coe/info6205/finalProject/LSDOutput.java
### benchmark result:
INFO6205/src/main/java/edu/neu/coe/info6205/finalProject/LSDResult.java
## 4. Tim sort
### algorithm:
INFO6205/src/main/java/edu/neu/coe/info6205/sort/linearithmic/TimSort.java
### unit test:
INFO6205/src/test/java/edu/neu/coe/info6205/sort/linearithmic/TimSortTest.java
### output:
INFO6205/src/main/java/edu/neu/coe/info6205/finalProject/TimSortOutput.java
### benchmark result:
INFO6205/src/main/java/edu/neu/coe/info6205/finalProject/TimResult.java
## 5. Dual-Pivot quick sort
### algorithm:
INFO6205/src/main/java/edu/neu/coe/info6205/sort/linearithmic/QuickSort_DualPivot.java
### unit test:
INFO6205/src/test/java/edu/neu/coe/info6205/sort/linearithmic/QuickSortDualPivotTest.java
### output:
INFO6205/src/main/java/edu/neu/coe/info6205/finalProject/QuickSort_DualPivotOutput.java
### benchmark result:
INFO6205/src/main/java/edu/neu/coe/info6205/finalProject/QuickSort_DualPivotResult.java
## 6. Husky sort
### algorithm:
INFO6205/src/main/java/edu/neu/coe/info6205/huskySort/sort/huskySort/PureHuskySort.java
### unit test:
INFO6205/src/test/java/edu/neu/coe/info6205/huskySort/sort/huskySort/PureHuskySortTest.java
### output:
INFO6205/src/main/java/edu/neu/coe/info6205/finalProject/huskyOutput.java
### benchmark result:
INFO6205/src/main/java/edu/neu/coe/info6205/finalProject/huskyResult.java
