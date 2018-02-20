/**
 * 
 */
package com.abnamro.pojo;

/**
 * @author VIKRAM
 *
 */
public final class FutureTransaction extends Transaction{

	/**
	 * 
	 */
	public FutureTransaction() {
		// TODO Auto-generated constructor stub
	}
	
	private String recordCode;
	private String clientType;
	private String clientNum;
	private String accountNum;
	private String subAcctNum;
	private String oppPartyCode;
	private String prodGrpCode;
	private String exchgCode;
	private String symbol;
	private String expryDate;
	private String currcyCode;
	private String mvmtCode;
	private String buySellCode;
	private String qtyLongSign;
	private String qtyLong;
	private String qtyShortSign;
	private String qtyShort;
	private String exchgBrkFeeDec;
	private String exchgBrkFeeDc;
	private String exchgBrkFeeCurrCode;
	private String clearingBrkFeeDec;
	private String clearingBrkFeeDc;
	private String clearingBrkFeeCurrCode;
	private String commBrkFeeDec;
	private String commBrkFeeDc;
	private String commBrkFeeCurrCode;
	private String transDate;
	private String futureRef;
	private String ticketNum;
	private String extNum;
	private String transPrice;
	private String traderInitials;
	private String oppTradeId;
	private String openCloseCode;
	private String clientInfo;
	private String prodInfo;
	private String transAmount;
	private String transKey;	
	
	
	public String getTransKey() {
		return getClientInfo()+"-"+getProdInfo()+"-"+getTransDate();
	}
	public String getClientInfo() {
		return this.getClientType()+this.getClientNum()+this.getAccountNum()+this.getSubAcctNum();
	}
	public String getProdInfo() {
		return this.getExchgCode()+this.getProdGrpCode()+this.getSymbol()+this.getExpryDate();
	}
	public int getTransAmount() {
		return (Integer.parseInt(this.getQtyLong())-Integer.parseInt(this.getQtyShort()));
	}
	public String getRecordCode() {
		return recordCode;
	}
	public void setRecordCode(String recordCode) {
		this.recordCode = recordCode;
	}
	public String getClientType() {
		return clientType;
	}
	public void setClientType(String clientType) {
		this.clientType = clientType;
	}
	public String getClientNum() {
		return clientNum;
	}
	public void setClientNum(String clientNum) {
		this.clientNum = clientNum;
	}
	public String getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}
	public String getSubAcctNum() {
		return subAcctNum;
	}
	public void setSubAcctNum(String subAcctNum) {
		this.subAcctNum = subAcctNum;
	}
	public String getOppPartyCode() {
		return oppPartyCode;
	}
	public void setOppPartyCode(String oppPartyCode) {
		this.oppPartyCode = oppPartyCode;
	}
	public String getProdGrpCode() {
		return prodGrpCode;
	}
	public void setProdGrpCode(String prodGrpCode) {
		this.prodGrpCode = prodGrpCode;
	}
	public String getExchgCode() {
		return exchgCode;
	}
	public void setExchgCode(String exchgCode) {
		this.exchgCode = exchgCode;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getExpryDate() {
		return expryDate;
	}
	public void setExpryDate(String expryDate) {
		this.expryDate = expryDate;
	}
	public String getCurrcyCode() {
		return currcyCode;
	}
	public void setCurrcyCode(String currcyCode) {
		this.currcyCode = currcyCode;
	}
	public String getMvmtCode() {
		return mvmtCode;
	}
	public void setMvmtCode(String mvmtCode) {
		this.mvmtCode = mvmtCode;
	}
	public String getBuySellCode() {
		return buySellCode;
	}
	public void setBuySellCode(String buySellCode) {
		this.buySellCode = buySellCode;
	}
	public String getQtyLongSign() {
		return qtyLongSign;
	}
	public void setQtyLongSign(String qtyLongSign) {
		this.qtyLongSign = qtyLongSign;
	}
	public String getQtyLong() {
		return qtyLong;
	}
	public void setQtyLong(String qtyLong) {
		this.qtyLong = qtyLong;
	}
	public String getQtyShortSign() {
		return qtyShortSign;
	}
	public void setQtyShortSign(String qtyShortSign) {
		this.qtyShortSign = qtyShortSign;
	}
	public String getQtyShort() {
		return qtyShort;
	}
	public void setQtyShort(String qtyShort) {
		this.qtyShort = qtyShort;
	}
	public String getExchgBrkFeeDec() {
		return exchgBrkFeeDec;
	}
	public void setExchgBrkFeeDec(String exchgBrkFeeDec) {
		this.exchgBrkFeeDec = exchgBrkFeeDec;
	}
	public String getExchgBrkFeeDc() {
		return exchgBrkFeeDc;
	}
	public void setExchgBrkFeeDc(String exchgBrkFeeDc) {
		this.exchgBrkFeeDc = exchgBrkFeeDc;
	}
	public String getExchgBrkFeeCurrCode() {
		return exchgBrkFeeCurrCode;
	}
	public void setExchgBrkFeeCurrCode(String exchgBrkFeeCurrCode) {
		this.exchgBrkFeeCurrCode = exchgBrkFeeCurrCode;
	}
	public String getClearingBrkFeeDec() {
		return clearingBrkFeeDec;
	}
	public void setClearingBrkFeeDec(String clearingBrkFeeDec) {
		this.clearingBrkFeeDec = clearingBrkFeeDec;
	}
	public String getClearingBrkFeeDc() {
		return clearingBrkFeeDc;
	}
	public void setClearingBrkFeeDc(String clearingBrkFeeDc) {
		this.clearingBrkFeeDc = clearingBrkFeeDc;
	}
	public String getClearingBrkFeeCurrCode() {
		return clearingBrkFeeCurrCode;
	}
	public void setClearingBrkFeeCurrCode(String clearingBrkFeeCurrCode) {
		this.clearingBrkFeeCurrCode = clearingBrkFeeCurrCode;
	}
	public String getCommBrkFeeDec() {
		return commBrkFeeDec;
	}
	public void setCommBrkFeeDec(String commBrkFeeDec) {
		this.commBrkFeeDec = commBrkFeeDec;
	}
	public String getCommBrkFeeDc() {
		return commBrkFeeDc;
	}
	public void setCommBrkFeeDc(String commBrkFeeDc) {
		this.commBrkFeeDc = commBrkFeeDc;
	}
	public String getCommBrkFeeCurrCode() {
		return commBrkFeeCurrCode;
	}
	public void setCommBrkFeeCurrCode(String commBrkFeeCurrCode) {
		this.commBrkFeeCurrCode = commBrkFeeCurrCode;
	}
	public String getTransDate() {
		return transDate;
	}
	public void setTransDate(String transDate) {
		this.transDate = transDate;
	}
	public String getFutureRef() {
		return futureRef;
	}
	public void setFutureRef(String futureRef) {
		this.futureRef = futureRef;
	}
	public String getTicketNum() {
		return ticketNum;
	}
	public void setTicketNum(String ticketNum) {
		this.ticketNum = ticketNum;
	}
	public String getExtNum() {
		return extNum;
	}
	public void setExtNum(String extNum) {
		this.extNum = extNum;
	}
	public String getTransPrice() {
		return transPrice;
	}
	public void setTransPrice(String transPrice) {
		this.transPrice = transPrice;
	}
	public String getTraderInitials() {
		return traderInitials;
	}
	public void setTraderInitials(String traderInitials) {
		this.traderInitials = traderInitials;
	}
	public String getOppTradeId() {
		return oppTradeId;
	}
	public void setOppTradeId(String oppTradeId) {
		this.oppTradeId = oppTradeId;
	}
	public String getOpenCloseCode() {
		return openCloseCode;
	}
	public void setOpenCloseCode(String openCloseCode) {
		this.openCloseCode = openCloseCode;
	}
	
	
	
	
	

}
