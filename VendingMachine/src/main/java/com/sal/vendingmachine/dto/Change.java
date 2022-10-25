
package com.sal.vendingmachine.dto;

import com.sal.vendingmachine.dao.VendingMachineException;
import com.sal.vendingmachine.service.VendingMachineInsufficientFundsException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.HashMap;

public class Change {
    private HashMap<Coins,Integer> coinChangeMap=new HashMap<>();

    public Change() {
    }

    public HashMap<Coins,Integer> getChange(BigDecimal funds) throws VendingMachineInsufficientFundsException{

        coinChangeMap.put(Coins.QUARTERS,funds.divide(Coins.QUARTERS.getValue()).intValue());
        funds = funds.remainder(Coins.QUARTERS.getValue());

        coinChangeMap.put(Coins.DIME,funds.divide(Coins.DIME.getValue()).intValue());
        funds = funds.remainder(Coins.DIME.getValue());

        coinChangeMap.put(Coins.NICKLE,funds.divide(Coins.NICKLE.getValue()).intValue());

        coinChangeMap.put(Coins.PENNY,funds.divide(Coins.PENNY.getValue()).intValue());

        return coinChangeMap;
    }
    
}
