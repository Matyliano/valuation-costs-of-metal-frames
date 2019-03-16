package matyliano.valuation.calculation.totalTime;


import matyliano.valuation.calculation.numberOfRepetitions.NumberOfRepetitions;
import matyliano.valuation.calculation.operationTime.OperationTime;
import org.springframework.stereotype.Service;

@Service
public class TotalTimeService {



    public TotalTime countingTotalOperationTime( ){

        NumberOfRepetitions numberOfRepetitions = new NumberOfRepetitions();
       double  x = numberOfRepetitions.getNumberOfRepetitions();

        OperationTime operationTime = new OperationTime();
        double y = operationTime.getOperationTime();



        TotalTime totalTime = new TotalTime();

        double calculatedTime = x*y;

        totalTime.setTotalTime( calculatedTime );


        return  totalTime;

}


}
