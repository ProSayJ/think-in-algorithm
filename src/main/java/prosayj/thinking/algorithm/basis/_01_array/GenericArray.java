package prosayj.thinking.algorithm.basis._01_array;

/**
 * 通用数组 实现
 *
 * @author yangjian
 * @date 2021-02-25 下午 01:24
 * @since 1.0.0
 */
public class GenericArray<T> {
    /**
     * 定义整型数据data保存数据
     */
    private T[] data;
    /**
     * 定义中实际个数
     */
    private int size;

    /**
     * 构造方法，定义数组大小
     *
     * @param capacity 容量
     */
    public GenericArray(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    /**
     * 无参构造方法，默认数组容量为10
     */
    public GenericArray() {
        this(10);
    }

    /**
     * 获取数组容量
     *
     * @return 返回数组实际容量
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 获取当前元素个数
     *
     * @return 返回当前元素个数
     */
    public int count() {
        return size;
    }

    /**
     * 判断数组是否为空
     *
     * @return true:空 false:不为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 修改 index 位置的元素
     *
     * @param index 待修改的目标位置
     * @param e     待修改的目标值
     */
    public void set(int index, T e) {
        checkIndex(index);
        data[index] = e;
    }

    /**
     * 获取对应 index 位置的元素
     *
     * @param index 目标索引位置
     * @return index 位置的元素
     */
    public T get(int index) {
        checkIndex(index);
        return data[index];
    }

    /**
     * 查看数组是否包含元素e
     *
     * @param e 目标元素
     * @return true:包含  fasle：不包含
     */
    public boolean contains(T e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 获取对应元素的下标,
     *
     * @param e 目标元素
     * @return 未找到，返回 -1
     */
    public int find(T e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }


    /**
     * 在 index 位置，插入元素e, 时间复杂度 O(m+n)
     *
     * @param index 目标位置
     * @param e     目标元素
     */
    public void add(int index, T e) {
        checkIndexForAdd(index);
        // 如果当前元素个数等于数组容量，则将数组扩容为原来的2倍
        if (size == data.length) {
            resize(2 * data.length);
        }

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    /**
     * 向数组头插入元素
     *
     * @param e 目标元素
     */
    public void addFirst(T e) {
        add(0, e);
    }

    /**
     * 向数组尾插入元素
     *
     * @param e 目标元素
     */
    public void addLast(T e) {
        add(size, e);
    }

    /**
     * 删除 index 位置的元素，并返回
     *
     * @param index 目标位置
     * @return 返回已经删除的元素
     */
    public T remove(int index) {
        checkIndex(index);

        T ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;

        // 缩容
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }

        return ret;
    }

    /**
     * 删除第一个元素
     *
     * @return 返回删除的元素
     */
    public T removeFirst() {
        return remove(0);
    }

    /**
     * 删除末尾元素
     *
     * @return 返回删除的元素
     */
    public T removeLast() {
        return remove(size - 1);
    }

    /**
     * 从数组中删除指定元素
     *
     * @param e 目标元素
     */
    public void removeElement(T e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Array size = %d, capacity = %d \n", size, data.length));
        builder.append('[');
        for (int i = 0; i < size; i++) {
            builder.append(data[i]);
            if (i != size - 1) {
                builder.append(", ");
            }
        }
        builder.append(']');
        return builder.toString();
    }


    /**
     * 扩容方法，时间复杂度 O(n)
     *
     * @param capacity 扩容大小
     */
    private void resize(int capacity) {
        T[] newData = (T[]) new Object[capacity];

        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    /**
     * 检查索引是否越界
     *
     * @param index 索引位置
     */
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Add failed! Require index >=0 and index < size.");
        }
    }

    /**
     * 添加元素时检查索引是否合法
     *
     * @param index 目标索引
     */
    private void checkIndexForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("remove failed! Require index >=0 and index <= size.");
        }
    }
}
