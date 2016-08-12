package com.wangkai.bean;

import java.math.BigDecimal;
//import lombok.Data;

/**
 * Created by admin on 16/7/11.
 */
public class DueResult {

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public int getStage() {
        return stage;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }

    public int getOverDueStages() {
        return overDueStages;
    }

    public void setOverDueStages(int overDueStages) {
        this.overDueStages = overDueStages;
    }

    public double getOverDueAmount() {
        return overDueAmount;
    }

    public void setOverDueAmount(double overDueAmount) {
        this.overDueAmount = overDueAmount;
    }

    public int getOverdueCount() {
        return overdueCount;
    }

    public void setOverdueCount(int overdueCount) {
        this.overdueCount = overdueCount;
    }

    public int getMaxOverdue() {
        return maxOverdue;
    }

    public void setMaxOverdue(int maxOverdue) {
        this.maxOverdue = maxOverdue;
    }

    public String getAddressProvince() {
        return addressProvince;
    }

    public void setAddressProvince(String addressProvince) {
        this.addressProvince = addressProvince;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public String getApplyAddressProvince() {
        return applyAddressProvince;
    }

    public void setApplyAddressProvince(String applyAddressProvince) {
        this.applyAddressProvince = applyAddressProvince;
    }

    public String getApplyAddressCity() {
        return applyAddressCity;
    }

    public void setApplyAddressCity(String applyAddressCity) {
        this.applyAddressCity = applyAddressCity;
    }

    public String getPhoneAddressProvince() {
        return phoneAddressProvince;
    }

    public void setPhoneAddressProvince(String phoneAddressProvince) {
        this.phoneAddressProvince = phoneAddressProvince;
    }

    public String getPhoneAddressCity() {
        return phoneAddressCity;
    }

    public void setPhoneAddressCity(String phoneAddressCity) {
        this.phoneAddressCity = phoneAddressCity;
    }

    @Override
    public String toString() {
        return custId + "," + userName + "," + orderId + "," + amount
                + "," + stage + "," + overDueStages + "," + overDueAmount + "," + overdueCount + "," + maxOverdue
                + "," + addressProvince + "," + addressCity + "," + applyAddressProvince + ","
                + applyAddressCity + "," + phoneAddressProvince + "," + phoneAddressCity;
    }
}
