// 当一个数组中大部分元素为０，或者为同一个值的数组时，可以使用稀疏数组来保存该数组。
// 稀疏数组的处理方法是:
// 1)、记录数组一共有几行几列，有多少个不同的值
// 2)、把具有不同值的元素的行列及值记录在一个小规模的数组中，从而缩小程序的规模
public class SparseArray {
    /*
    打印棋盘,并返回有效值的个数
     */
    private static int printChess(int[][] chessArray) {
        int count = 0;
        for (int[] ints : chessArray) {
            for (int anInt : ints) {
                System.out.print(anInt);
                System.out.print("\t");
                if (anInt != 0) {
                    count++;
                }
            }
            System.out.println();
        }
        return count;
    }

    /*
    将棋盘的二维数组转化为稀疏数组
    chessArray1: 为棋盘数组
    countNum: 为有效值的个数
     */
    private static int[][] chessArrayToSparseArray(int[][] chessArray1, int countNum) {
        // 稀疏数组的大小为: (有效值个数 + 1) * 3
        // 稀疏数组的第一行为 行个数 列个数 有效值个数
        // 稀疏数组的其余行为 行号  列号  数值
        int[][] sparseArray = new int[countNum + 1][3];

        // 初始化稀疏数组的第一行
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = countNum;

        int counts = 0;

        for (int i = 0; i < chessArray1.length; i++) {
            for (int j = 0; j < chessArray1[i].length; j++) {
                if (chessArray1[i][j] != 0) {
                    counts++;
                    sparseArray[counts][0] = i;
                    sparseArray[counts][1] = j;
                    sparseArray[counts][2] = chessArray1[i][j];
                }
            }
        }
        return sparseArray;
    }

    /*
    将稀疏数组转化为棋盘数组
     */
    private static int[][] sparseArrayToChessArray(int[][] sparseArray) {
        // 根据稀疏数组的第一行确定 棋盘数组的大小[行 * 列]
        int maxRow = sparseArray[0][0];
        int maxColumn = sparseArray[0][1];
        int[][] chessArray2 = new int[maxRow][maxColumn];

        // 根据有效值个数确定循环次数
        for (int i = 1; i <= sparseArray[0][2]; i++) {
            chessArray2[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        return chessArray2;

    }

    public static void main(String[] args) {

        // 创建棋盘数组, 并初始化棋盘为(黑棋为1)和(白棋为2)
        int[][] chessArray1 = new int[11][11];
        chessArray1[1][2] = 1;
        chessArray1[2][3] = 2;
        // 打印棋盘
        int countNum = printChess(chessArray1);
        // 将棋盘数组转化为稀疏数组
        int[][] sparseArray = chessArrayToSparseArray(chessArray1, countNum);
        printChess(sparseArray);

        // 将稀疏数组转化为棋盘数组
        int[][] chessArray2 = sparseArrayToChessArray(sparseArray);
        printChess(chessArray2);
    }
}
