package com.loan.util;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

import java.util.Iterator;
import java.util.List;

import com.loan.entities.CreditIntermediary;
import com.loan.entities.Lender;
import com.loan.entities.Loan;

public class CustomDataSource implements JRDataSource {
    private final List<Object> dataList;
    private Iterator<Object> iterator;
    private Object currentObject;

    public CustomDataSource(List<Object> dataList) {
        this.dataList = dataList;
        this.iterator = dataList.iterator();
    }

    @Override
    public boolean next() throws JRException {
        if (iterator.hasNext()) {
            currentObject = iterator.next();
            return true;
        }
        return false;
    }

    @Override
    public Object getFieldValue(JRField jrField) throws JRException {
        // Implement this method to return the appropriate field value from the currentObject
        String fieldName = jrField.getName();

        // Assuming your objects have getter methods for fields, adjust the method calls based on your object structure
        if (currentObject instanceof CreditIntermediary) {
        	CreditIntermediary yourObject = (CreditIntermediary) currentObject;
            if ("fieldName".equals(fieldName)) {
                return yourObject.getCompanyName();
            }
            // Add more conditions for other fields
        }
     // Assuming your objects have getter methods for fields, adjust the method calls based on your object structure
        if (currentObject instanceof Lender) {
        	Lender yourObject = (Lender) currentObject;
            if ("fieldName".equals(fieldName)) {
                return yourObject.getName();
            }
            // Add more conditions for other fields
        }
        // Assuming your objects have getter methods for fields, adjust the method calls based on your object structure  
        if (currentObject instanceof Loan) {
            Loan loan = (Loan) currentObject;
            if ("consumerName".equals(fieldName)) {
                return loan.getConsumerName();
            }
            // Add more conditions for other fields
        }

        return null;
    }
}

