/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package w10j1.tandem.topcomponent;

import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.util.NbBundle;
import org.openide.windows.TopComponent;
import w10j1.tandem.usercommand.UserCommand;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(dtd = "-//w10j1.tandem.topcomponent//Tandem//EN",
autostore = false)
@TopComponent.Description(preferredID = "TandemTopComponent",
//iconBase="SET/PATH/TO/ICON/HERE", 
persistenceType = TopComponent.PERSISTENCE_ALWAYS)
@TopComponent.Registration(mode = "editor", openAtStartup = true)
@ActionID(category = "Window", id = "w10j1.tandem.topcomponent.TandemTopComponent")
@ActionReference(path = "Menu/Window" /*
 * , position = 333
 */)
@TopComponent.OpenActionRegistration(displayName = "#CTL_TandemAction",
preferredID = "TandemTopComponent")
public final class TandemTopComponent extends TopComponent {

    private String outputStr;
    private UserCommand userCommand = new UserCommand();

    public TandemTopComponent() {
        initComponents();
        setName(NbBundle.getMessage(TandemTopComponent.class, "CTL_TandemTopComponent"));
        setToolTipText(NbBundle.getMessage(TandemTopComponent.class, "HINT_TandemTopComponent"));
        WelcomeLabel.setText("Welcome to Tandem! The time is now " + this.getDate());
    }

    private String getDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date date = new Date();
        return dateFormat.format(date);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        WelcomeLabel = new javax.swing.JLabel();
        CommandLabel = new javax.swing.JLabel();
        InputTextField = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        TaskList =  new javax.swing.JList(resultModel);
        jScrollPane1 = new javax.swing.JScrollPane();
        ActionList = new javax.swing.JList();

        org.openide.awt.Mnemonics.setLocalizedText(WelcomeLabel, org.openide.util.NbBundle.getMessage(TandemTopComponent.class, "TandemTopComponent.WelcomeLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(CommandLabel, org.openide.util.NbBundle.getMessage(TandemTopComponent.class, "TandemTopComponent.CommandLabel.text")); // NOI18N

        InputTextField.setText(org.openide.util.NbBundle.getMessage(TandemTopComponent.class, "TandemTopComponent.InputTextField.text")); // NOI18N
        InputTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputTextFieldActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(TaskList);

        jScrollPane1.setViewportView(ActionList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(CommandLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(InputTextField))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(WelcomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 345, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(WelcomeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CommandLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(InputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void InputTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputTextFieldActionPerformed
            String input = InputTextField.getText();
            userCommand.initCommand(input);
            userCommand.execute();
            resultModel.addElement(this.outputStr);
            InputTextField.setText("");
    }//GEN-LAST:event_InputTextFieldActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList ActionList;
    private javax.swing.JLabel CommandLabel;
    private javax.swing.JTextField InputTextField;
    private javax.swing.JList TaskList;
    private javax.swing.JLabel WelcomeLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
    javax.swing.DefaultListModel<String> resultModel = new javax.swing.DefaultListModel();
    
    @Override
    public void componentOpened() {
    }

    @Override
    public void componentClosed() {
        // TODO add custom code on component closing
    }

    void writeProperties(java.util.Properties p) {
        // better to version settings since initial version as advocated at
        // http://wiki.apidesign.org/wiki/PropertyFiles
        p.setProperty("version", "1.0");
        // TODO store your settings
    }

    void readProperties(java.util.Properties p) {
        String version = p.getProperty("version");
        // TODO read your settings according to their version
    }
}