/*
  (c) Copyright 2018, 2019 Phasmid Software
 */
package edu.neu.coe.info6205.huskySort.sort.simple;

import edu.neu.coe.info6205.huskySort.sort.BaseHelper;
import edu.neu.coe.info6205.huskySort.sort.Helper;
import edu.neu.coe.info6205.huskySort.sort.SortWithHelper;
import edu.neu.coe.info6205.huskySort.util.Config;

import java.util.Arrays;

/**
 * Sorter which delegates to Timsort via Arrays.sort.
 *
 * @param <X>
 */
public class TimSort<X extends Comparable<X>> extends SortWithHelper<X> {

    /**
     * @param xs   sort the array xs from "from" until "to" (exclusive of to).
     * @param from the index of the first element to sort.
     * @param to   the index of the first element not to sort.
     */
    @Override
    public void sort(X[] xs, int from, int to) {
        Arrays.sort(xs, from, to);
    }

    public static final String DESCRIPTION = "Timsort";

    /**
     * Constructor for TimSort
     *
     * @param helper an explicit instance of Helper to be used.
     */
    public TimSort(Helper<X> helper) {
        super(helper);
    }

    /**
     * Constructor for TimSort
     *
     * @param N      the number elements we expect to sort.
     * @param config the configuration.
     */
    public TimSort(int N, Config config) {
        super(DESCRIPTION, N, config);
    }

    public TimSort() {
        this(new BaseHelper<>(DESCRIPTION));
    }
}

