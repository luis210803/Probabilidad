public class Main {
    public static void main(String[] args) {
        // Crear el DataSet de clima
        DataSet dataSet = new DataSet();
        dataSet.initialize();

        // Calcular y mostrar probabilidades marginales
        System.out.println("\nProbabilidades Marginales:");
        Probabilities probabilities = new Probabilities(dataSet);
        probabilities.printMarginalProbabilities();

        // Calcular y mostrar probabilidades conjuntas
        System.out.println("\nProbabilidades Conjuntas:");
        probabilities.printJointProbabilities();

        // Calcular y mostrar probabilidades condicionales
        System.out.println("\nProbabilidades Condicionales:");
        probabilities.printConditionalProbabilities();
    }
}


