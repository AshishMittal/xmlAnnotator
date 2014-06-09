package in.ac.iitb.XMLAnnotator;
import java.io.File;
import java.util.HashMap;
import java.util.List;


import javax.xml.bind.JAXBContext;

import javax.xml.bind.Unmarshaller;




public class XMLObjectConversion {

	public static void main(String args[]){
		try{
			File file = new File("/home/darkwire/Desktop/XMLData/ans.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(AllSnippetSet.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			
			AllSnippetSet allSnippetSet = (AllSnippetSet) jaxbUnmarshaller.unmarshal(file);
			
			File q_file = new File("/home/darkwire/Desktop/XMLData/queriesForTemporalTagging.xml");
			JAXBContext q_jaxbContext = JAXBContext.newInstance(TemporalQueries.class);
			Unmarshaller q_jaxbUnmarshaller = q_jaxbContext.createUnmarshaller();
			
			TemporalQueries temporalQueries = (TemporalQueries) q_jaxbUnmarshaller.unmarshal(q_file);
			
			HashMap<Integer,TemporalQueries.IitbQuantitySearchQuery> queryMap = new HashMap<Integer, TemporalQueries.IitbQuantitySearchQuery>();
			List<TemporalQueries.IitbQuantitySearchQuery> searchQuantity = (List<TemporalQueries.IitbQuantitySearchQuery>) temporalQueries.getIitbQuantitySearchQuery();
			for(TemporalQueries.IitbQuantitySearchQuery searchResult : searchQuantity){
				int id = searchResult.getNumericID();
				queryMap.put(id, searchResult);
				//System.out.println(searchResult.getNumericID());
			}
			
		//	System.out.println(allSnippetSet);
			
			List<AllSnippetSet.SnippetSet> snippetSets = (List<AllSnippetSet.SnippetSet>) allSnippetSet.getSnippetSet();
			
			for(AllSnippetSet.SnippetSet snippetSet : snippetSets){
				
				int id=snippetSet.getQid();
				TemporalQueries.IitbQuantitySearchQuery query = (TemporalQueries.IitbQuantitySearchQuery) queryMap.get(id);
				if(query == null){
					break;
				}
				
				
				List<AllSnippetSet.SnippetSet.Snippet> snippetList = snippetSet.getSnippet();
				
				for(AllSnippetSet.SnippetSet.Snippet snippet : snippetList){
					System.out.println(query.getQueryString());
					System.out.println(snippet.getText());
					System.out.println(snippet.getQuantity1());
					System.out.println(snippet.getQuantity2());
					System.out.println(snippet.getAns());
					List<AllSnippetSet.SnippetSet.Snippet.TIMEX3> timexList = snippet.getTIMEX3();
					for(AllSnippetSet.SnippetSet.Snippet.TIMEX3 timex3 : timexList){
						System.out.println("Timex Value: "+timex3.getValue());
					}
				}
			}
			
			//SnippetSet snippetSets = allSnippetSet.getSnippetSet();
			
			System.out.println("Read Successfull");
			
	/*	Code to write all the objects back to file..	
	 * 	Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			 
			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	 
			File outputFile = new File("/home/darkwire/Desktop/jaxb.xml");
			jaxbMarshaller.marshal(allSnippetSet, outputFile);
			jaxbMarshaller.marshal(allSnippetSet, System.out);
		*/
		}
		
		catch(Exception e){
			System.out.println("Exception: "+e);
		}
		
	}
}
