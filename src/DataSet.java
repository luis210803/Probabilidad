import java.util.Arrays;
import java.util.List;

public class DataSet {
    private int[][] data;
    private List<String> listData;
    private boolean isMatrix;

    public void initialize() {
        // Ejemplo de DataSet de 5x5
        data = new int[][] {
                {2, 3, 1, 4, 5},
                {3, 4, 2, 5, 6},
                {4, 5, 3, 6, 7},
                {5, 6, 4, 7, 8},
                {6, 7, 5, 8, 9}
        };
        isMatrix = true;

        // Ejemplo de DataSet adicional proporcionado (lista)
        // Descomentar la siguiente línea para usar el DataSet de lista
        // listData = Arrays.asList("AB", "AC", "BC", "AB", "AC", "AC", "BC", "AB", "AB", "BC", "CA", "AB", "BC", "CA", "AB", "CA", "AB", "BC", "CA");
        // isMatrix = false;
    }

    public int[][] getData() {
        return data;
    }

    public List<String> getListData() {
        return listData;
    }

    public boolean isMatrix() {
        return isMatrix;
    }
}



