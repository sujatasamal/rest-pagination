package com.sample.restpagination.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.sample.restpagination.model.Result;
import com.sample.restpagination.model.Results;

@Component
public class RestPaginationService {
	public static int DEFAULT_SIZE = 20;
	List<Result> resultList;
	
	public RestPaginationService(){
		resultList = createResultsList();
	}

	public Results getResults(int pageNumber, int size) {		
		int startIndix = (pageNumber-1)*size;
		int endIndex = startIndix+size;
		int resultsSize = resultList.size();
		//when last page has items less than size
		if( endIndex > resultsSize) { endIndex = resultsSize; }
		
		Results results = new Results();
		//invalid page /if no items exist in the supplied page then return empty
		if(startIndix < resultsSize) {
			//populate the parent object
			results.setResult(resultList.subList(startIndix, endIndex));
			results.setNextPage(pageNumber+1);
			results.setPreviousPage(pageNumber-1);
			results.setTotal(resultsSize);
			//last page check
			if(endIndex >= resultsSize){
				results.setLastPage(true);
			}
		}
		return results;
	}
	
	private List<Result> createResultsList() {		
		List<Result> resultList = new ArrayList<Result>();
		Result result = null;
		for(int i= 1 ; i < 51 ;i++ ){
			result = new Result();
			result.setHref("https://link/to/result&quot");
			result.setTitle("Document Title : " + i);
			result.setSummary("Docuemtn Summary : " + i);
			resultList.add(result);
		}
		return resultList;
	}
}
