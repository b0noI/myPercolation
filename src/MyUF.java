class MyUF {

    private int[] id;
    private int[] treeSize;

    /**
     *Constructor.
     * @param n - Amount of elements.
     */
    MyUF(int n) {
        this.id = new int[n];
        treeSize = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
            treeSize[i] = 1;
        }
    }

    /**
     * The method confirms or denies the relationship between the arguments.
     * @param p - first argument p >= 0 && p < n
     * @param q - second argument q >= 0 && p < n
     */
    boolean isConnected(int p, int q) {
        return root(p) == root(q);
    }

    /**
     * The method searches for the root for the input argument.
     * @param i - the argument must be within: i >= 0 && i < n
     * @return
     */
    private int root(int i) {
        validate(i);
        while(i != id[i]){
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }

    /**
     * Checks the validity of the argument.
     * @param i - the argument to check.
     */
    private void validate(int i) {
        if (i < 0 || i >= id.length) {
            throw new IllegalArgumentException("Index "
                    + i
                    + " in unacceptable limits. Valid values are from 0 to "
                    + (id.length-1)
                    +".");
        }
    }

    /**
     * This method weightedly combines the specified arguments.
     * @param p - first argument p >= 0 && p < n
     * @param q - second argument q >= 0 && p < n
     */
    void union(int p, int q) {
        validate(p);
        validate(q);
        int i = root(p);
        int j = root(q);

        if (i == j) return;

        if  (treeSize[i] < treeSize[j]) {
            id[i] = j;
            treeSize[j] += treeSize[i];
        }  else{
            id[j] = i;
            treeSize[i] += treeSize[j];
        }
    }
}
