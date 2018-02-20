package java;

import static org.junit.Assert.*;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

import com.abnamro.service.FutureTransProcessor;

public class FutureTransProcessorTest {

	
	
	@Test
	public void testGenerateDailySummaryReportInvalidInputFileException() {
		FutureTransProcessor rport = new FutureTransProcessor();
		 Path path = Paths.get("\\src/Input.xt");
		 boolean thrown = false;
		try {
			rport.generateDailySummaryReport(path,"20100820");
		} catch (Exception e) {
			 thrown = true;
			 assertTrue(thrown);
		}
		
		
		
	}
	
	@Test
	public void testGenerateDailySummaryReportInvalidTransactionException() {
		FutureTransProcessor rport = new FutureTransProcessor();
		 Path path = Paths.get("/temp/Input_invalidtransactions.txt");
		 boolean thrown = false;
		try {
			rport.generateDailySummaryReport(path,"201020");
		} catch (Exception e) {
			 thrown = true;
			 assertTrue(thrown);
		}
		
		
		
	}
	
	@Test
	public void testGenerateDailySummaryReportForUnavailableDateException() {
		FutureTransProcessor rport = new FutureTransProcessor();
		 Path path = Paths.get("/temp/Input.txt");
		 boolean thrown = false;
		try {
			rport.generateDailySummaryReport(path,"20171220");
		} catch (Exception e) {
			 thrown = true;
			 assertTrue(thrown);
		}
		
		
		
	}
	
	
	@Test
	public void testGenerateDailySummaryReportInvalidFileTypeException() {
		FutureTransProcessor rport = new FutureTransProcessor();
		 Path path = Paths.get("/temp/Input.pt");
		 boolean thrown = false;
		try {
			rport.generateDailySummaryReport(path,"201020");
		} catch (Exception e) {
			 thrown = true;
			 assertTrue(thrown);
		}
		
		
		
	}
	
	@Test
	public void testGenerateDailySummaryReportInvalidDateException() {
		FutureTransProcessor rport = new FutureTransProcessor();
		 Path path = Paths.get("/temp/Input.txt");
		 boolean thrown = false;
		try {
			rport.generateDailySummaryReport(path,"201020");
		} catch (Exception e) {
			 thrown = true;
			 assertTrue(thrown);
		}
		
		
		
	}

}
