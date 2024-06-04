import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Probabilities {
    private int[][] data;
    private List<String> listData;
    private boolean isMatrix;
    private int total;

    public Probabilities(DataSet dataSet) {
        this.isMatrix = dataSet.isMatrix();
        if (isMatrix) {
            this.data = dataSet.getData();
            this.total = 0;
            for (int i = 0; i < data.length - 1; i++) {
                for (int j = 0; j < data[i].length; j++) {
                    this.total += data[i][j];
                }
            }
        } else {
            this.listData = dataSet.getListData();
            this.total = listData.size();
        }
    }

    // Método para imprimir probabilidades marginales
    public void printMarginalProbabilities() {
        if (isMatrix) {
            for (int i = 0; i < data.length - 1; i++) {
                double pA = (double) data[data.length - 1][i] / total;
                System.out.printf("P(A%d) = %.2f\n", i + 1, pA);
            }
            for (int j = 0; j < data[0].length; j++) {
                double pB = (double) data[j][data[0].length - 1] / total;
                System.out.printf("P(B%d) = %.2f\n", j + 1, pB);
            }
        } else {
            Map<String, Integer> frequency = new HashMap<>();
            for (String s : listData) {
                for (char c : s.toCharArray()) {
                    frequency.put(String.valueOf(c), frequency.getOrDefault(String.valueOf(c), 0) + 1);
                }
            }

            for (Map.Entry<String, Integer> entry : frequency.entrySet()) {
                System.out.printf("P(%s) = %.2f\n", entry.getKey(), (double) entry.getValue() / total);
            }
        }
    }

    // Método para imprimir probabilidades conjuntas
    public void printJointProbabilities() {
        if (isMatrix) {
            for (int i = 0; i < data.length - 1; i++) {
                for (int j = 0; j < data[i].length - 1; j++) {
                    double pAB = (double) data[i][j] / total;
                    System.out.printf("P(A%d∩B%d) = %.2f\n", i + 1, j + 1, pAB);
                }
            }
        } else {
            Map<String, Integer> frequency = new HashMap<>();
            for (String s : listData) {
                frequency.put(s, frequency.getOrDefault(s, 0) + 1);
            }

            for (Map.Entry<String, Integer> entry : frequency.entrySet()) {
                System.out.printf("P(%s) = %.2f\n", entry.getKey(), (double) entry.getValue() / total);
            }
        }
    }

    // Método para imprimir probabilidades condicionales
    public void printConditionalProbabilities() {
        if (isMatrix) {
            for (int i = 0; i < data.length - 1; i++) {
                for (int j = 0; j < data[i].length - 1; j++) {
                    double pBGivenA = (double) data[i][j] / data[data.length - 1][j];
                    System.out.printf("P(B%d|A%d) = %.2f\n", j + 1, i + 1, pBGivenA);
                }
            }
            for (int j = 0; j < data[0].length - 1; j++) {
                for (int i = 0; i < data.length - 1; i++) {
                    double pAGivenB = (double) data[i][j] / data[j][data[0].length - 1];
                    System.out.printf("P(A%d|B%d) = %.2f\n", i + 1, j + 1, pAGivenB);
                }
            }
        } else {
            Map<String, Integer> singleFrequency = new HashMap<>();
            Map<String, Integer> pairFrequency = new HashMap<>();

            for (String s : listData) {
                for (char c : s.toCharArray()) {
                    singleFrequency.put(String.valueOf(c), singleFrequency.getOrDefault(String.valueOf(c), 0) + 1);
                }
                pairFrequency.put(s, pairFrequency.getOrDefault(s, 0) + 1);
            }

            for (Map.Entry<String, Integer> entry : pairFrequency.entrySet()) {
                String pair = entry.getKey();
                char condition = pair.charAt(0);
                System.out.printf("P(%s|%s) = %.2f\n", pair.charAt(1), condition, (double) entry.getValue() / singleFrequency.get(String.valueOf(condition)));
            }
        }
    }
}



