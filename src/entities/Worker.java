package entities;

import entities.enums.WorkerLevel;

import java.util.ArrayList;
import java.util.List;

public class Worker {
    private String name;
    private WorkerLevel level;
    private Double baseSalary;
    private List<HourContract> contracts = new ArrayList<>();
    private Departament departament;

    public Worker(String name, WorkerLevel level, Double baseSalary, Departament departament){
        this.name = name;
        this.level = level;
        this.baseSalary = baseSalary;
        this.departament = departament;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public WorkerLevel getLevel(){
        return level;
    }

    public void setLevel(WorkerLevel level){
        this.level = level;
    }

    public Double getBaseSalary(){
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary){
        this.baseSalary = baseSalary;
    }

    public void addContract(HourContract contract){
        contracts.add(contract);
    }

    public void removeContract(HourContract contract){
            contracts.remove(contract);
    }

    public Double income(Integer year, Integer month){
        double val = 0.0;
        for(HourContract contrato : contracts){
            if(year == contrato.getDate().getYear() && month == contrato.getDate().getMonthValue()){
                val += contrato.getTotalValue();
            }
        }
        return val + baseSalary;
    }

    @Override
    public String toString() {
        return """
               Name : %s
               Departament: %s
               """.formatted(name,departament);
    }
}
