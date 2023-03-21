package seminar_5.Infrastucture.OperationAll;

import java.util.Map;

/**
 * Хранилище операций для компоненты калькулятора комплексных чисел
 */

public class OperationStorageComplex extends OperationStorage{

    public OperationStorageComplex() {
        super();
    }

    @Override
    public Map<Integer, String> getOperationMap() {
        return super.getOperationMap();
    }

    @Override
    public void addOperation(Integer key, String operation) {
        super.addOperation(key, operation);
    }

    @Override
    public String operationMenu() {
        StringBuilder operationMenu = new StringBuilder();
        operationMenu.append(" ВВЕДИТЕ ЧИСЛО, СОГЛАСНО МЕНЮ \n");
        for (Map.Entry<Integer, String> el : getOperationMap().entrySet()) {
            operationMenu.append("    ").append(el.getKey()).append(" => ").append("ОПЕРАЦИЯ \"")
                    .append(el.getValue()).append("\" КОМПЛЕКСНЫХ ЧИСЕЛ\n");
        }
        return operationMenu.toString();
    }
}