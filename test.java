package day0419;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ScannerAppExample {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("输入长宽高：");

        // 保存用户输入参数
        Map<String, Double> inputMap = new HashMap<>();

        // 输入三个值 长宽高
        for (int index = 0; index < 3; index++) {
            double currentInput = scanner.nextDouble();
            inputMap.put(CuboidEnums.getCuboidPropertyKey(index), currentInput);
        }

        // 打印当前用户所输入
        System.out.println(inputMap);

        // 将数组中的值赋值给长方体类
        // 1.方法1: 循环将数组中的值进行赋值
        // 新建一个长方体对象
        Cuboid cuboid = new Cuboid(inputMap.get(CuboidEnums.LENGTH_KEY.getKey()),
                inputMap.get(CuboidEnums.WIDTH_KEY.getKey()),
                inputMap.get(CuboidEnums.HEIGHT_KEY.getKey()));
        Double volume = cuboid.getVolume();
        System.out.println(volume);
    }


    /**
     *
     * 长方体类
     */
    static class Cuboid {

        /** 长 */
        private Double length;

        /** 宽 */
        private Double width;

        /** 高 */
        private Double height;

        public Cuboid() {
        }

        public Cuboid(Double length, Double width, Double height) {
            this.length = length;
            this.width = width;
            this.height = height;
        }

        /**
         * 获得长方体的体积
         *
         * @return 长方体的体积
         */
        public Double getVolume() {
            return length * width * height;
        }

        public Double getLength() {
            return length;
        }

        public void setLength(Double length) {
            this.length = length;
        }

        public Double getWidth() {
            return width;
        }

        public void setWidth(Double width) {
            this.width = width;
        }

        public Double getHeight() {
            return height;
        }

        public void setHeight(Double height) {
            this.height = height;
        }
    }

    /**
     * 长方体类型枚举对象
     * 保存了长方体内的三个属性
     */
    enum CuboidEnums {

        /**
         * 长度的key
         */
        LENGTH_KEY(0, "length"),

        /** 宽度的key */
        WIDTH_KEY(1, "width"),

        /** 高度的key */
        HEIGHT_KEY(2, "height"),

        // other type
        ;

        CuboidEnums(int index, String key) {
            this.index = index;
            this.key = key;
        }

        /** 位置索引 */
        private int index;

        /** 属性的可以 */
        private String key;

        public int getIndex() {
            return index;
        }

        public String getKey() {
            return key;
        }

        /**
         * 通过传入的索引值，获得长方体相应索引对应属性的key
         *
         * @param index 对应的索引值
         * @return
         * @throws IllegalArgumentException 当找不到对应属性，则抛出异常
         */
        public static String getCuboidPropertyKey(int index) {
            for (CuboidEnums value : CuboidEnums.values()) {
                int currentIndex = value.getIndex();
                if (index == currentIndex) {
                    return value.getKey();
                }
            }
            // 结束后还是找不到 直接抛出一个异常
            throw new IllegalArgumentException("非法的输入参数，请重试");
        }
    }


}
