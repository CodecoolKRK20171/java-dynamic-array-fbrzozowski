package com.codecool.dynamicArrayDojo;

public class DynamicIntArray {

    private int[] array;

    public DynamicIntArray() {
        this.array = new int[0];
    }

    public DynamicIntArray(int length) {
        this.array = new int[length];
    }

    public void add(int number) {
        resizeArray();
        this.array[this.array.length - 1] = number;
    }

    public void insert(int index, int value) {
        int oldArraySize = this.array.length;

        if (index >= oldArraySize) {
            add(value);
        } else {
            int[] newArray = new int[oldArraySize + 1];

            for (int i = 0; i <= index; i++) {
                newArray[i] = this.array[i];
            }
            newArray[index] = value;

            for (int i = index + 1; i < newArray.length; i++) {
                if (i <= oldArraySize) {
                    newArray[i] = this.array[i - 1];
                }
            }
            this.array = newArray;
        }
    }

    public void remove(int index) {
        validateIndex(index);
        int arrayLength = this.array.length;
        int[] newArray = new int[arrayLength - 1];
        for (int i = 0; i < arrayLength; i++) {
            if (i < index) {
                newArray[i] = this.array[i];
            } else if (i > index) {
                newArray[i-1] = this.array[i];
            }
        }
        this.array = newArray;
    }

    private void resizeArray() {
        int i = this.array.length;
        int n = ++i;
        int[] newArray = new int[n];
        for (int cnt = 0; cnt < this.array.length; cnt++) {
            newArray[cnt] = this.array[cnt];
        }
        this.array = newArray;
    }

    private void validateIndex(int index) throws ArrayIndexOutOfBoundsException {
        if (index > this.array.length - 1) throw new ArrayIndexOutOfBoundsException();
        if (index < 0) throw new ArrayIndexOutOfBoundsException();
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < this.array.length; i++) {
            str.append(" ");
            str.append(this.array[i]);
        }
        return str.toString();
    }
}
