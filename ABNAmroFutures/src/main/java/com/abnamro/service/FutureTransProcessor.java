package com.abnamro.service;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.springframework.util.StringUtils;

import com.abnamro.pojo.FutureTransaction;

public class FutureTransProcessor {
	private static final String COL_HEADER = "Client_Information,Product_Information,Total_Transaction_Amount\n";
	private static final String COL_SEPERATOR = ",";
	private static final String LINE_SEPERATOR = "\n";
	
	

	public static void main(String[] args) throws Exception{
		
		try {		
			FutureTransProcessor rport = new FutureTransProcessor();
			//rport.generateDailySummaryReport("src/Input.txt","20100820");
				
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}        
	}
	
	public void generateDailySummaryReport(Path inputFile,String day)  throws Exception{
		
		List<String> inputTransList=null;
		HashMap<String,Double> uniqueTrans =null;
		HashMap<String,List<String>> dailySummary =null;
			try{
				SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
				SimpleDateFormat format2 = new SimpleDateFormat("yyyyMMdd");
				Date date = format1.parse(day);
				String strDate = format2.format(date);
				
				
				  if(null!=day&&!StringUtils.isEmpty(day) &&inputFile.toFile().exists())
				  {
					  //Read Input 
					  inputTransList = readInput(inputFile);
					  if(inputTransList!=null&&inputTransList.size()>0){
						  //Process each transaction and aggregate unique transactions
						  uniqueTrans = processFutTransactions(inputTransList);
					  }
					  else{
						  throw new Exception("Error  reading input file");
						  
					  }
					  if(uniqueTrans!=null&&uniqueTrans.entrySet().size()>0){
						  //Separate unique transactions on daily basis
						  dailySummary = prepareDailyReport(uniqueTrans);
				  	  }
					  else{
						  throw new Exception("Error processing transactionss");
						  
					  }
				  	  if(dailySummary!=null&&dailySummary.get(strDate)!=null&&dailySummary.get(strDate).size()>0){
						  //Write CSV file
						  writeReport(dailySummary.get(strDate),strDate );	
				  	  }
				  	  else{
						  throw new Exception("Summary report not found the given date");
						  
					  }
				  }else{
					  throw new Exception("Invalid Date and Input file path");
				  }
			
			}
			catch(Exception e){
				throw e;
			}
		
	}
	
	protected List<String> readInput(Path inputFilePath) throws Exception{
		List<String> lines = null;
		try{
		 lines = Files.readAllLines(inputFilePath, StandardCharsets.UTF_8);
		}
		catch(Exception e){
			throw new Exception("Error  reading input file");
		}
		return lines;
	}
	
	protected HashMap<String,Double> processFutTransactions(List<String> lines)throws Exception{
		HashMap<String,Double> prodTransMap = new HashMap<String,Double>();
		List<FutureTransaction> ftrTrans = new ArrayList<FutureTransaction>();
		
		try{
		
		for (Iterator<String> iterator = lines.iterator(); iterator.hasNext();) {
			String lintext =  iterator.next();
			
			FutureTransaction trans = new FutureTransaction();
			trans.setRecordCode(lintext.substring(0, 3));
			
			//Client Info
			trans.setClientType(lintext.substring(3, 7));
			trans.setClientNum(lintext.substring(7, 11));
			trans.setAccountNum(lintext.substring(11, 15));
			trans.setSubAcctNum(lintext.substring(15, 19));
			
			//Product Info
			trans.setExchgCode(lintext.substring(27, 31));
			trans.setProdGrpCode(lintext.substring(25, 27));
			trans.setSymbol(lintext.substring(31, 37));
			trans.setExpryDate(lintext.substring(37, 45));
			
			//Transaction amount
			trans.setQtyLong(lintext.substring(52, 62));
			trans.setQtyShort(lintext.substring(63, 73));				
			
			//Transaction date
			trans.setTransDate(lintext.substring(121,129));
			
			ftrTrans.add(trans);
			
			prodTransMap.put(trans.getTransKey(),
					prodTransMap.containsKey(trans.getTransKey())
					?prodTransMap.get(trans.getTransKey())+trans.getTransAmount()
					:trans.getTransAmount());
										
			
		}
		}
		catch(Exception e){
			throw new Exception("Error processing transactionss");
		}
		return prodTransMap;
	}
	
	protected HashMap<String,List<String>> prepareDailyReport(HashMap<String,Double> prodTransMap )throws Exception{
		HashMap<String,List<String>> dailyReport = new HashMap<String,List<String>>();
		
		try{
		for (Map.Entry<String, Double> entry : prodTransMap.entrySet())
		{
		    StringTokenizer strTkn = new StringTokenizer(entry.getKey(), "-");		    
		    	String clientInfo = strTkn.hasMoreTokens()?strTkn.nextToken():"";
		    	String prodInfo = strTkn.hasMoreTokens()?strTkn.nextToken():"";
		    	String transDate = strTkn.hasMoreTokens()?strTkn.nextToken():"";
		    	Double transAmount = entry.getValue();		    	
		    	String key = clientInfo + COL_SEPERATOR + prodInfo + COL_SEPERATOR + transAmount;	    
		    if(dailyReport.containsKey(transDate)){
				dailyReport.get(transDate).add(key);	
			}
			else{
			List<String> newEntry = new ArrayList<String>();
			newEntry.add(key);
			dailyReport.put(transDate, newEntry);
			}
		}
		}
		catch(Exception e){
			throw new Exception("Error prapring summary report");
		}
		return dailyReport;
	}
	
	protected void writeReport(List<String> results,String date) throws IOException, Exception{
		FileWriter writer = null;
		try{
	    writer = new FileWriter("/temp/Output"+date+".csv");
	    writer.append(COL_HEADER);
		for (String result : results) {
			writer.append(result);
			writer.append(LINE_SEPERATOR);
				
		}
		} catch (Exception e) {	
		            System.out.println("Error in inputFile !!!");		
		            e.printStackTrace();	
		            throw e;
		} finally {
		            try {
		            	writer.flush();		
		            	writer.close();		
		            } catch (IOException e) {		
		                System.out.println("Error while flushing/closing fileWriter !!!");
		                e.printStackTrace();
		                throw e;
		            }		             
		        }
		}
	
	
	
	

}
