package com.wangkai.bean;

import java.math.BigDecimal;
import lombok.Data;

/**
 * Created by admin on 16/7/11.
 */
public @Data class DueResult {

    private String userName;

    private int custId;

    private int orderId;

    private BigDecimal amount;

    private int stage;

    private int overDueStages = 0;

    private double overDueAmount = 0;

    private int overdueCount = 0;

    private int maxOverdue = 0;

    private String addressProvince;

    private String addressCity;

    private String applyAddressProvince;

    private String applyAddressCity;

    private String phoneAddressProvince;

    private String phoneAddressCity;

    @Override
    public String toString() {
        return custId + "," + userName + "," + orderId + "," + amount
                + "," + stage + "," + overDueStages + "," + overDueAmount + "," + overdueCount + "," + maxOverdue
                + "," + addressProvince + "," + addressCity + "," + applyAddressProvince + ","
                + applyAddressCity + "," + phoneAddressProvince + "," + phoneAddressCity;
    }
}
