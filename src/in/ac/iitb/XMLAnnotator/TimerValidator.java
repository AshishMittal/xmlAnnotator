package in.ac.iitb.XMLAnnotator;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.event.ActionEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;




/**
 *
 * @author sunny
 */
public class TimerValidator extends javax.swing.JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private File XMLFile;
	private File QueryFile;
	private AllSnippetSet allSnippetSet;
	private TemporalQueries temporalQueries;
	private HashMap<Integer,TemporalQueries.IitbQuantitySearchQuery> queryMap;
	private ArrayList<AllSnippetSet.SnippetSet> snippetSet;
	private int snippetSetIndex;
	private int snippetIndex;
	private AllSnippetSet.SnippetSet.Snippet snippet;
	private ArrayList<AllSnippetSet.SnippetSet.Snippet> snippetList;
	private ArrayList<AllSnippetSet.SnippetSet.Snippet.TIMEX3> timexList;
	private Boolean EOF; //End of File
	private Boolean BOF; //Beginning of File
	private AllSnippetSet.SnippetSet.Snippet.TIMEX3 timex3;
	/**
	 * Creates new form RelevanceChecker
	 */
	public TimerValidator() {  //Initialized when program starts..
		
		try{
			
			snippetSetIndex = 0;
			snippetIndex = 0;
			XMLFile = new File("/home/darkwire/Desktop/XMLData/ans.xml"); //path to XML file containing snippets
		
			JAXBContext jaxbContext = JAXBContext.newInstance(AllSnippetSet.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();		
			allSnippetSet = (AllSnippetSet) jaxbUnmarshaller.unmarshal(XMLFile);

			QueryFile = new File("/home/darkwire/Desktop/XMLData/queriesForTemporalTagging.xml"); //path to xml file containing queries for temporal tagging.
			
			JAXBContext q_jaxbContext = JAXBContext.newInstance(TemporalQueries.class);
			Unmarshaller q_jaxbUnmarshaller = q_jaxbContext.createUnmarshaller();

			temporalQueries = (TemporalQueries) q_jaxbUnmarshaller.unmarshal(QueryFile);
			
			queryMap = new HashMap<Integer, TemporalQueries.IitbQuantitySearchQuery>();
			List<TemporalQueries.IitbQuantitySearchQuery> searchQuantity = (List<TemporalQueries.IitbQuantitySearchQuery>) temporalQueries.getIitbQuantitySearchQuery();
			for(TemporalQueries.IitbQuantitySearchQuery searchResult : searchQuantity){
				int id = searchResult.getNumericID();
				queryMap.put(id, searchResult);
			}
			snippetSet = (ArrayList<AllSnippetSet.SnippetSet>) allSnippetSet.getSnippetSet();
			
		}catch(Exception e){
			System.out.println("Exception: "+e);
		}
		
		initComponents();
		jLayeredPane2.setVisible(false);

		initTimeInfoPanel();
	}
	
	

	private void initTimeInfoPanel(){

		if(snippetSetIndex >= snippetSet.size()){
			//Reached the end of the file....
			EOF = true;
		}
		else{
			int id=snippetSet.get(snippetSetIndex).getQid();
			TemporalQueries.IitbQuantitySearchQuery query = (TemporalQueries.IitbQuantitySearchQuery) queryMap.get(id);
			String queryString;
			if(query == null){
				queryString = "No query found.";
			}
			else{
				queryString = query.getQueryString();
			}
			snippetList = (ArrayList<AllSnippetSet.SnippetSet.Snippet>) snippetSet.get(snippetSetIndex).getSnippet();
			
			if(snippetIndex >= snippetList.size()){
				//reached the end of snippet list..Go for next Snippet Set..
			}
			else{
				//Get the snippet..
				snippet = snippetList.get(snippetIndex);
				
				jTextArea2.setText(queryString);
				jTextArea1.setText(snippet.getText());
				jTextArea1.setLineWrap(true);
				jTextArea2.setLineWrap(true);
				
				timexList = (ArrayList<AllSnippetSet.SnippetSet.Snippet.TIMEX3>)snippet.getTIMEX3();
				int num = timexList.size();
				timePanes = new Vector<javax.swing.JLayeredPane>(num);
				
				
				int ycoordinate= 200;
				
				for(int i=0;i<num;++i){
					timex3 = timexList.get(i);
					javax.swing.JLayeredPane jlp = new javax.swing.JLayeredPane();
					jLabel6 = new javax.swing.JLabel();
					jLabel7 = new javax.swing.JLabel();
					jLabel8 = new javax.swing.JLabel();
					
					jTextField1 = new javax.swing.JTextField();
					jTextField1.setText(timex3.getValue());
					
					jTextField2 = new javax.swing.JTextField();
					jTextField2.setText(timex3.getTid());
					
					jTextField3 = new javax.swing.JTextField();
					jTextField3.setText(timex3.getType());
					
					jRadioButton1 = new javax.swing.JRadioButton();
					jRadioButton2 = new javax.swing.JRadioButton();
					if(timex3.getIsRelevant() == 1){
						jRadioButton1.setSelected(true);
					}
					else{
						jRadioButton2.setSelected(true);
					}
					
					jRadioButton3 = new javax.swing.JRadioButton();
					jRadioButton4 = new javax.swing.JRadioButton();
					//System.out.println(timex3.getIsCorrect());
					if(timex3.getIsCorrect() != null){
						if(timex3.getIsCorrect() == 1){
							jRadioButton3.setSelected(true);
						}
						else{
							jRadioButton4.setSelected(true);
						}
					}
					else{
						jRadioButton4.setSelected(true);
					}
					
					buttonGroup2 = new javax.swing.ButtonGroup();
					buttonGroup1 = new javax.swing.ButtonGroup();
	
					jLabel6.setText("Type:");
					jLabel6.setBounds(170, 0, 38, 18);
					jlp.add(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
	
					jLabel7.setText("Value:");
					jLabel7.setBounds(380, 0, 43, 18);
					jlp.add(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
	
					jLabel8.setText("ID:");
					jLabel8.setBounds(10, 0, 30, 18);
					jlp.add(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);
	
					jTextField1.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent evt) {
							jTextField1ActionPerformed(evt);
						}
					});
					jTextField1.setBounds(440, 0, 110, 28);
					jlp.add(jTextField1, javax.swing.JLayeredPane.DEFAULT_LAYER);
	
					jTextField2.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent evt) {
							jTextField2ActionPerformed(evt);
						}
					});
					jTextField2.setBounds(50, 0, 100, 28);
					jlp.add(jTextField2, javax.swing.JLayeredPane.DEFAULT_LAYER);
		
					jTextField3.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent evt) {
							jTextField3ActionPerformed(evt);
						}
					});
					jTextField3.setBounds(230, 0, 110, 28);
					jlp.add(jTextField3, javax.swing.JLayeredPane.DEFAULT_LAYER);
		
					buttonGroup1.add(jRadioButton1);
					jRadioButton1.setText("Relevant");
					jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent evt) {
							jRadioButton1ActionPerformed(evt);
						}
					});
					jRadioButton1.setBounds(50, 60, 86, 24);
					jlp.add(jRadioButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);
		
					buttonGroup1.add(jRadioButton2);
					jRadioButton2.setText("Irrelevant");
					jRadioButton2.setBounds(50, 80, 93, 24);
					jlp.add(jRadioButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);
		
					buttonGroup2.add(jRadioButton3);
					jRadioButton3.setText("Correct");
					jRadioButton3.setBounds(410, 60, 80, 24);
					jlp.add(jRadioButton3, javax.swing.JLayeredPane.DEFAULT_LAYER);
		
					buttonGroup2.add(jRadioButton4);
					jRadioButton4.setText("Incorrect");
					jRadioButton4.setBounds(410, 80, 90, 24);
					jlp.add(jRadioButton4, javax.swing.JLayeredPane.DEFAULT_LAYER);
		
					jlp.setBounds(700, ycoordinate, 570, 110);
					jlp.setVisible(true);
					
					this.add(jlp);
					
					invalidate();
					validate();
					pack();
		
					timePanes.add(jlp);
					ycoordinate = ycoordinate + 130;
				}
			}
		}
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
	   private void initComponents() {

        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea(); //Snippet Text
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea(); //Query String
        jLabel4 = new javax.swing.JLabel();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField(); //Timex attribute value
        jTextField2 = new javax.swing.JTextField(); //Timex ID
        jTextField3 = new javax.swing.JTextField(); //Timex attribute Type
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jButtonPrev = new javax.swing.JButton(); //previous button
        jButtonNext = new javax.swing.JButton(); //next button 
        jButtonSave = new javax.swing.JButton(); //save button

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		setPreferredSize(new java.awt.Dimension(1300, 700));
	    setAlwaysOnTop(true);
	    setResizable(false);
	        
	    setTitle("Timer Attribute Validator");

        jLabel1.setText("Query ID:");

        jLabel3.setText("Query:");

        jLabel5.setText("Text:");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButtonPrev.setText("<< Prev");

        jButtonNext.setText("Next >>");

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jLabel4.setText("Time Attributes:");

        jLabel6.setText("Type:");
        jLabel6.setBounds(160, 0, 38, 20);
        jLayeredPane2.add(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel7.setText("Value:");
        jLabel7.setBounds(370, 0, 43, 20);
        jLayeredPane2.add(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel8.setText("ID:");
        jLabel8.setBounds(0, 0, 30, 20);
        jLayeredPane2.add(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButtonNext.addActionListener(new java.awt.event.ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (snippetSetIndex < snippetSet.size() - 1){
					if(snippetIndex < snippetList.size()){
						snippetIndex ++;
					}
					else{
						snippetSetIndex ++;
					}
				}
				else{
					EOF = true;
				}
				initTimeInfoPanel();
			}
        });
        jButtonPrev.addActionListener(new java.awt.event.ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (snippetSetIndex > 0){
					if(snippetIndex > 0){
						snippetIndex --;
					}
					else{
						snippetSetIndex --;
					}
				}
				else{
					BOF = true;
				}
				initTimeInfoPanel();
			}
        });
        
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.setBounds(430, 0, 110, 30);
        jLayeredPane2.add(jTextField1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jTextField2.setBounds(40, 0, 100, 30);
        jLayeredPane2.add(jTextField2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        jTextField3.setBounds(220, 0, 110, 30);
        jLayeredPane2.add(jTextField3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Relevant");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        jRadioButton1.setBounds(40, 60, 86, 30);
        jLayeredPane2.add(jRadioButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Irrelevant");
        jRadioButton2.setBounds(40, 80, 93, 30);
        jLayeredPane2.add(jRadioButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        buttonGroup2.add(jRadioButton3);
        jRadioButton3.setText("Correct");
        jRadioButton3.setBounds(400, 60, 80, 30);
        jLayeredPane2.add(jRadioButton3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        buttonGroup2.add(jRadioButton4);
        jRadioButton4.setText("Incorrect");
        jRadioButton4.setBounds(400, 80, 90, 30);
        jLayeredPane2.add(jRadioButton4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButtonSave.setText("Save");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(82, 82, 82)
                                        .addComponent(jButtonPrev)
                                        .addGap(117, 117, 117)
                                        .addComponent(jButtonNext))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(178, 178, 178)
                                        .addComponent(jButtonSave)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(52, 52, 52))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(104, 104, 104)
                                .addComponent(jButtonSave))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonPrev)
                            .addComponent(jButtonNext))))
                .addContainerGap(255, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                       
                            

	private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {                                            
		// TODO add your handling code here:
	}                                           

	private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {                                            
		// TODO add your handling code here:
	}                                           

	private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {                                            
		// TODO add your handling code here:
	}                                           

	private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                              
		// TODO add your handling code here:
	}                                             

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
		/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
		 * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(TimerValidator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(TimerValidator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(TimerValidator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(TimerValidator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {				
				new TimerValidator().setVisible(true);
			}
		});
	}
	
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    Vector<javax.swing.JLayeredPane> timePanes;
    private javax.swing.JButton jButtonPrev;
    private javax.swing.JButton jButtonNext;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
	// End of variables declaration                   
}
