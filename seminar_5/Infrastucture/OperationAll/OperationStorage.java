package seminar_5.Infrastucture.OperationAll;

import java.util.HashMap;
import java.util.Map;

/**
 * Хранилище операций (создание словаря операций и вывода меню на основе данных словаря).
 */

public abstract class OperationStorage {
    private final Map<Integer, String> operationMap = new HashMap<>();

    public OperationStorage() {
    }

    public Map<Integer, String> getOperationMap() {
        return operationMap;
    }

    public void addOperation(Integer key, String operation){
        operationMap.put(key, operation);
    }

    public String operationMenu(){
        StringBuilder operationMenu = new StringBuilder();
        operationMenu.append(" ВВЕДИТЕ ЧИСЛО, СОГЛАСНО МЕНЮ \n");
        for (Map.Entry<Integer, String> el : this.operationMap.entrySet()) {
            operationMenu.append("    ").append(el.getKey()).append(" => ").append("ОПЕРАЦИЯ \"")
                    .append(el.getValue()).append("\"\n");
        }
        return operationMenu.toString();
    }
}
