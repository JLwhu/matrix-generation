/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package matrixgeneration;

import conversion.TaxonCharacterMatrix;
import generateFileToTaxonMap.FileName2TaxonLoader;
import generateFileToTaxonMap.FileName2TaxonLoaderFNA;
import generateFileToTaxonMap.Filename2TaxonFinder;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.log4j.Logger;
import javax.swing.JFileChooser;
import javax.swing.Timer;
import processListen.ProcessListener;
import taxonomy.TaxonHierarchy;
import taxonomy.TaxonRank;

class MyCustomFilter extends javax.swing.filechooser.FileFilter {

    @Override
    public boolean accept(File file) {
        // Allow only directories, or files with ".txt" extension
        return file.isDirectory() || file.getAbsolutePath().endsWith(".txt");
    }

    @Override
    public String getDescription() {
        // This description will be displayed in the dialog,
        // hard-coded = ugly, should be done via I18N
        return "Text documents (*.txt)";
    }
}

/**
 *
 * @author jingliu5
 */
public class MatrixGenerateUI extends javax.swing.JFrame {
    protected static final Logger LOGGER = Logger.getLogger(MatrixGenerateUI.class);
    List characterFeatureList = new ArrayList();
    HashMap mappingRuleMap = new HashMap();
    ArrayList<String> headers;
 //   String singPluralFilepath;  
    String inputDirPath;
    String outdirPath = "C:\\Users\\jingliu5\\UFLwork\\Data\\SDD\\Spongesmatrices\\";
    String matricesFileName = "v10matrices.txt";
    Filename2TaxonFinder filenameTaxon;
    ProcessListener processListener;
    boolean finished = false;
    String lastS="";
    Timer timer = new Timer(1, new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
            stepProgressBar.setValue(processListener.getCurrentPercentage());
            String s = processListener.getCurrentMessage();
            String newline = "\n";
            if (s != null&& !s.equals(lastS)) {
                lastS = s;
                processOutputTextArea.append(s + newline);
                processOutputTextArea.setCaretPosition(
                        processOutputTextArea.getDocument().getLength());
            }
            if (processListener.getCurrentPercentage() == 100) {
                //    Toolkit.getDefaultToolkit().beep();
                finished = true;
                timer.stop();
                setCursor(null); //turn off the wait cursor
                stepProgressBar.setValue(stepProgressBar.getMinimum());
            }
        }
    });

    /**
     * Creates new form MatrixCoverstionUI
     */
    public MatrixGenerateUI() {
        initComponents();
        //  stepProgressBar.setVisible(false);    


    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        singularPluralFileChooser = new javax.swing.JFileChooser();
        mappingChoiceButtonGroup = new javax.swing.ButtonGroup();
        outputFormatChoiceButtonGroup = new javax.swing.ButtonGroup();
        inputDirectoryChooser = new javax.swing.JFileChooser();
        outputFileChooser = new javax.swing.JFileChooser();
        outputRankButtonGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        inputDirTextField = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        nameComboBox = new javax.swing.JComboBox();
        rankComboBox = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        PeaudoRankRadioButton = new javax.swing.JRadioButton();
        ChooseRankRadioButton = new javax.swing.JRadioButton();
        jPanel6 = new javax.swing.JPanel();
        saveMatrixButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        processOutputTextArea = new javax.swing.JTextArea();
        stepProgressBar = new javax.swing.JProgressBar();

        singularPluralFileChooser.setFileFilter( new MyCustomFilter());
        singularPluralFileChooser.setFileHidingEnabled(false);

        inputDirectoryChooser.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Step 1: Input Files"));
        jPanel1.setToolTipText("");
        jPanel1.setName(""); // NOI18N

        inputDirTextField.setEditable(false);

        jButton2.setText("Choose Input Directory(.xml files)");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jButton2ItemStateChanged(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(inputDirTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputDirTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Step 2: Choose Rank"));
        jPanel2.setToolTipText("Step2");

        nameComboBox.setEnabled(false);
        nameComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                nameComboBoxItemStateChanged(evt);
            }
        });
        nameComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameComboBoxActionPerformed(evt);
            }
        });
        nameComboBox.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nameComboBoxFocusGained(evt);
            }
        });

        rankComboBox.setEnabled(false);
        rankComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rankComboBoxItemStateChanged(evt);
            }
        });
        rankComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rankComboBoxActionPerformed(evt);
            }
        });

        jLabel1.setText("Rank");

        jLabel2.setText("Rank Name");

        outputRankButtonGroup.add(PeaudoRankRadioButton);
        PeaudoRankRadioButton.setSelected(true);
        PeaudoRankRadioButton.setText("Peudo Root");
        PeaudoRankRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PeaudoRankRadioButtonActionPerformed(evt);
            }
        });

        outputRankButtonGroup.add(ChooseRankRadioButton);
        ChooseRankRadioButton.setText("Choose Rank");
        ChooseRankRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChooseRankRadioButtonActionPerformed(evt);
            }
        });
        ChooseRankRadioButton.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                ChooseRankRadioButtonPropertyChange(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(PeaudoRankRadioButton)
                        .addGap(71, 71, 71)
                        .addComponent(ChooseRankRadioButton)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rankComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                        .addComponent(nameComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PeaudoRankRadioButton)
                    .addComponent(ChooseRankRadioButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rankComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addContainerGap())
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Step 3: Save Matrix File"));

        saveMatrixButton.setText("Save Matrix To File");
        saveMatrixButton.setEnabled(false);
        saveMatrixButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveMatrixButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(saveMatrixButton)
                .addGap(99, 99, 99))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(saveMatrixButton)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Status"));

        processOutputTextArea.setColumns(20);
        processOutputTextArea.setRows(5);
        processOutputTextArea.setFocusable(false);
        jScrollPane1.setViewportView(processOutputTextArea);

        stepProgressBar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(stepProgressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stepProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.getAccessibleContext().setAccessibleName("Step 1: Choose Inputs");
        jPanel2.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>                        

    private void saveMatrixButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        // TODO add your handling code here:
        int returnVal = outputFileChooser.showSaveDialog(this);
        if (returnVal == outputFileChooser.APPROVE_OPTION) {
            File file = outputFileChooser.getSelectedFile();
            // What to do with the file, e.g. display it in a TextArea
            outdirPath = file.getAbsolutePath();
            try {

                MatrixGeneration mg = new MatrixGeneration(inputDirPath, filenameTaxon.getValueMap(), file);  //singPluralFilepath, //by Jing Liu Oct.31,2013
                processListener = new ProcessListener(mg);
                TaxonHierarchy th;
                if (PeaudoRankRadioButton.isSelected()) {
                    mg.setIsPeudoroot(true);
                } else {
                    mg.setIsPeudoroot(false);
                    mg.setRankName((String) nameComboBox.getSelectedItem());
                    String rank = (String) rankComboBox.getSelectedItem();
                    mg.setRank(TaxonRank.valueOf(rank.toUpperCase()));
                }
                processListener = new ProcessListener(mg);
                mg.attach(processListener);
                mg.execute();
                timer.start();

                //      TaxonCharacterMatrix matrix = new TaxonCharacterMatrix(th);
                //       matrix.generateMatrixFile(file);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                StringWriter sw = new StringWriter();PrintWriter pw = new PrintWriter(sw);e.printStackTrace(pw);
                LOGGER.error(sw.toString());
            }
        }
    }                                                

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        int returnVal = inputDirectoryChooser.showOpenDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            try {
                File file = inputDirectoryChooser.getSelectedFile();
                // What to do with the file, e.g. display it in a TextArea
                inputDirPath = file.getAbsolutePath() + "/";
                inputDirTextField.setText(inputDirPath);

                FileName2TaxonLoader filename2Taxonloader;

                filename2Taxonloader = new FileName2TaxonLoaderFNA(inputDirPath);

                filenameTaxon = new Filename2TaxonFinder(filename2Taxonloader.getValuesMap());
                processListener = new ProcessListener(filename2Taxonloader);
                filename2Taxonloader.attach(processListener);
                saveMatrixButton.setEnabled(true);

                filename2Taxonloader.execute();
                timer.start();
            } catch (Exception ex) {
                StringWriter sw = new StringWriter();PrintWriter pw = new PrintWriter(sw);ex.printStackTrace(pw);
                LOGGER.error(sw.toString());
            }
        } else {
            System.out.println("File access cancelled by user.");
        }

    }                                        

    private void rankComboBoxActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
    }                                            

    private void rankComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {                                              
        int index = rankComboBox.getSelectedIndex();
        String rank = (String) rankComboBox.getSelectedItem();
        
        nameComboBox.removeAllItems();
        TaxonRank taxonrank = TaxonRank.valueOf(rank.toUpperCase());
        List<String> nameList = filenameTaxon.getRankNamesForGivenRank(taxonrank);
        for (String r : nameList) {
            nameComboBox.addItem(r);
        }
    }                                             

    private void nameComboBoxFocusGained(java.awt.event.FocusEvent evt) {                                         
    }                                        

    private void nameComboBoxActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
    }                                            

    private void nameComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {                                              
    }                                             

    private void PeaudoRankRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                      
        if (PeaudoRankRadioButton.isSelected()) {
            rankComboBox.setEnabled(false);
            nameComboBox.setEnabled(false);
        } else {
            rankComboBox.setEnabled(true);
            nameComboBox.setEnabled(true);
        }
    }                                                     

    private void ChooseRankRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                      
        if (ChooseRankRadioButton.isSelected()) {
            List<String> nonEmptyRankList = filenameTaxon.getNonEmptyRankList();
            for (String r : nonEmptyRankList) {
                rankComboBox.addItem(r);
            }

            rankComboBox.setEnabled(true);
            nameComboBox.setEnabled(true);

        } else {
            rankComboBox.setEnabled(false);
            nameComboBox.setEnabled(false);
        }
    }                                                     

    private void ChooseRankRadioButtonPropertyChange(java.beans.PropertyChangeEvent evt) {                                                     
        // TODO add your handling code here:
    }                                                    

    private void jButton2ItemStateChanged(java.awt.event.ItemEvent evt) {                                          
    }                                         

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {                                      
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
            java.util.logging.Logger.getLogger(MatrixGenerateUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MatrixGenerateUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MatrixGenerateUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MatrixGenerateUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MatrixGenerateUI().setVisible(true);

            }
        });
    }
    // Variables declaration - do not modify                     
    private javax.swing.JRadioButton ChooseRankRadioButton;
    private javax.swing.JRadioButton PeaudoRankRadioButton;
    private javax.swing.JTextField inputDirTextField;
    private javax.swing.JFileChooser inputDirectoryChooser;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.ButtonGroup mappingChoiceButtonGroup;
    private javax.swing.JComboBox nameComboBox;
    private javax.swing.JFileChooser outputFileChooser;
    private javax.swing.ButtonGroup outputFormatChoiceButtonGroup;
    private javax.swing.ButtonGroup outputRankButtonGroup;
    private javax.swing.JTextArea processOutputTextArea;
    private javax.swing.JComboBox rankComboBox;
    private javax.swing.JButton saveMatrixButton;
    private javax.swing.JFileChooser singularPluralFileChooser;
    private javax.swing.JProgressBar stepProgressBar;
    // End of variables declaration                   
}
