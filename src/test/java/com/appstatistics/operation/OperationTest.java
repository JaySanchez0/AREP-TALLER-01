package com.appstatistics.operation;

import com.appstatistics.collection.LinkedListImp;
import com.appstatistics.operation.exception.OperationException;
import org.junit.Test;

import static org.junit.Assert.*;

public class OperationTest {
    /**
     * Valida que un conjunto valido le pueda ser calculado el promedio
     * @throws OperationException
     */
    @Test
    public void wouldCalculateTheAverage() throws OperationException {
        LinkedListImp list = new LinkedListImp();
        list.add(2.0);
        list.add(3.0);
        list.add(10.0);
        double val = Operation.average(list);
        double expected = 5.0;
        assertEquals(val,expected,0.0);
    }

    /**
     * Valida que una lista vacia no le pueda ser calculado el promedio
     */
    @Test
    public void shouldBeFailWithEmptySet(){
        LinkedListImp list = new LinkedListImp();
        try {
            System.out.println(Operation.average(list));
            fail();
        }catch(OperationException e){
            assertEquals(list.length(),0);
        }
    }

    @Test
    public void wouldCalculateTheDeviation() throws OperationException {
        double x = 2.0;
        double y = 3.0;
        double av = 2.5;
        double num = Math.sqrt(Math.pow((x-av),2)+Math.pow((y-av),2));
        LinkedListImp list = new LinkedListImp();
        list.add(x);
        list.add(y);
        assertEquals(Operation.deviation(list),num,0.0);
    }

}
