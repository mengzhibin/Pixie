/*
 * The MIT License
 *
 * Copyright 2017 Olimpia Popica, Benone Aligica
 *
 * Contact: contact[a(t)]annotate[(d){o}t]zone
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package gui.viewer;

import common.Constants;
import attributes.DynamicTree;
import observers.NotifyObservers;
import observers.ObservedActions;
import gui.support.CustomTreeNode;
import gui.support.LAttributesFrame;
import java.awt.EventQueue;
import java.awt.KeyboardFocusManager;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Olimpia Popica
 */
public class AttributesDefinition extends javax.swing.JDialog implements Observer {

    /**
     * logger instance
     */
    private final transient org.slf4j.Logger log = LoggerFactory.getLogger(AttributesDefinition.class);

    /**
     * The name of the objects tab.
     */
    public static final String TAB_OBJECT = "Object";
    /**
     * The name of the frame tab.
     */
    public static final String TAB_FRAME = "Frame";

    /**
     * Encapsulates the list of frame attributes: illumination, weather etc.
     */
    private final LAttributesFrame frameAttribString;

    /**
     * Encapsulates the list of object attributes: type, class, value.
     */
    private CustomTreeNode objectAttributes;

    /**
     * Encapsulates the list of frame attributes: illumination, weather etc.
     */
    private CustomTreeNode<String> frameAttributes;

    /**
     * Makes the marked methods observable. It is part of the mechanism to
     * notify the frame on top about changes.
     */
    private final transient NotifyObservers observable = new NotifyObservers();

    /**
     * The tree mapping the object attributes.
     */
    private DynamicTree objTreePanel;

    /**
     * The tree mapping the frame attributes.
     */
    private DynamicTree frameTreePanel;

    /**
     * The depth of the object attributes tree.
     */
    private static final int OBJ_ATTRIB_TREE_DEPTH = 4;

    /**
     * The depth of the object attributes tree.
     */
    private static final int FRAME_ATTRIB_TREE_DEPTH = 3;

    /**
     * The list of fixed frame attributes.
     */
    private static final String[] FRAME_ATTRIBUTE_NAMES = {Constants.FRAME_ATTRIBUTES_TEXT, "Illumination", "Weather", "Road Type", "Road Event", "Country"};

    /**
     * Creates new form AttributesDefinition
     *
     * @param parent the parent component of the dialog
     * @param frameAttrib the frame attributes to be displayed on the interface,
     * as an array list of strings.
     * @param objAttrib the object attributes to be displayed on the interface,
     * as an array list of strings.
     */
    public AttributesDefinition(java.awt.Frame parent, LAttributesFrame frameAttrib, CustomTreeNode objAttrib) {
        super(parent, true);

        initComponents();

        addKeyboardListener();

        frameAttribString = frameAttrib;
        objectAttributes = objAttrib;

        loadFrameAttributes();

        loadObjectAttributes();

        prepareFrame();
    }

    /**
     * Code related to the frame like: pack, set location etc.
     */
    private void prepareFrame() {
        this.pack();
        this.setMinimumSize(this.getSize());

        this.setLocationRelativeTo(null);
    }

    /**
     * Set the frame attributes from the application configuration.
     */
    private void loadFrameAttributes() {
        populateFrameTree(true);

        configureFrameAttribTree();
    }

    /**
     * Allows another module to put an observer into the current module.
     *
     * @param o - the observer to be added
     */
    public void addObserver(Observer o) {
        observable.addObserver(o);

        // notify to remove the gui key event dispatcher
        observable.notifyObservers(ObservedActions.Action.REMOVE_GUI_KEY_EVENT_DISPATCHER);
    }

    /**
     * Add keyboard listener to the dialog window.
     */
    private void addKeyboardListener() {
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher((KeyEvent e) -> {
            int key = e.getKeyCode();

            if (key == KeyEvent.VK_ESCAPE) {
                closeWindow();
            }

            return false;
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPContainer = new javax.swing.JPanel();
        jTPAttributes = new javax.swing.JTabbedPane();
        jPFrameAttrib = new javax.swing.JPanel();
        jPFrameAttribExpand = new javax.swing.JPanel();
        jBFrameExpand = new javax.swing.JButton();
        jBFrameCollapse = new javax.swing.JButton();
        jPFrameAttribPreviewTree = new javax.swing.JPanel();
        javax.swing.JPanel jPFrameButtons = new javax.swing.JPanel();
        jBRemoveFrameAttrib = new javax.swing.JButton();
        jBClearFrameAttrib = new javax.swing.JButton();
        jPFrameAttribButtons = new javax.swing.JPanel();
        jBAddFrameAttrib = new javax.swing.JButton();
        jTFFrameAttribName = new javax.swing.JTextField();
        javax.swing.JPanel jPObjectDefinition = new javax.swing.JPanel();
        jPObjAttributesDefinition = new javax.swing.JPanel();
        jPObjAttribPreviewTree = new javax.swing.JPanel();
        javax.swing.JPanel jPObjButtons = new javax.swing.JPanel();
        jBRemoveObjAttrib = new javax.swing.JButton();
        jBClearObjAttrib = new javax.swing.JButton();
        jPObjAttribButtons = new javax.swing.JPanel();
        jBAddObjAttrib = new javax.swing.JButton();
        jTFObjAttribName = new javax.swing.JTextField();
        jPObjAttribExpand = new javax.swing.JPanel();
        jBObjExpand = new javax.swing.JButton();
        jBObjCollapse = new javax.swing.JButton();
        jBSaveAttributes = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Attributes");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPContainer.setBackground(new java.awt.Color(255, 255, 255));
        jPContainer.setLayout(new java.awt.GridBagLayout());

        jTPAttributes.setBackground(new java.awt.Color(255, 255, 255));
        jTPAttributes.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTPAttributesStateChanged(evt);
            }
        });

        jPFrameAttrib.setBackground(new java.awt.Color(255, 255, 255));
        jPFrameAttrib.setLayout(new java.awt.GridBagLayout());

        jPFrameAttribExpand.setBackground(new java.awt.Color(255, 255, 255));
        jPFrameAttribExpand.setLayout(new java.awt.GridBagLayout());

        jBFrameExpand.setBackground(new java.awt.Color(255, 255, 255));
        jBFrameExpand.setText("+");
        jBFrameExpand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBFrameExpandActionPerformed(evt);
            }
        });
        jPFrameAttribExpand.add(jBFrameExpand, new java.awt.GridBagConstraints());

        jBFrameCollapse.setBackground(new java.awt.Color(255, 255, 255));
        jBFrameCollapse.setText("-");
        jBFrameCollapse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBFrameCollapseActionPerformed(evt);
            }
        });
        jPFrameAttribExpand.add(jBFrameCollapse, new java.awt.GridBagConstraints());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        jPFrameAttrib.add(jPFrameAttribExpand, gridBagConstraints);

        jPFrameAttribPreviewTree.setBackground(new java.awt.Color(255, 255, 255));
        jPFrameAttribPreviewTree.setPreferredSize(new java.awt.Dimension(200, 320));
        jPFrameAttribPreviewTree.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 0.01;
        gridBagConstraints.weighty = 0.01;
        jPFrameAttrib.add(jPFrameAttribPreviewTree, gridBagConstraints);

        jPFrameButtons.setBackground(new java.awt.Color(255, 255, 255));
        jPFrameButtons.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPFrameButtons.setLayout(new java.awt.GridBagLayout());

        jBRemoveFrameAttrib.setBackground(new java.awt.Color(255, 255, 255));
        jBRemoveFrameAttrib.setText("Remove");
        jBRemoveFrameAttrib.setToolTipText("Removes the selected attributes.");
        jBRemoveFrameAttrib.setPreferredSize(new java.awt.Dimension(90, 32));
        jBRemoveFrameAttrib.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRemoveFrameAttribActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.weightx = 0.01;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPFrameButtons.add(jBRemoveFrameAttrib, gridBagConstraints);

        jBClearFrameAttrib.setBackground(new java.awt.Color(255, 255, 255));
        jBClearFrameAttrib.setText("Clear All");
        jBClearFrameAttrib.setToolTipText("Removes ALL the attributes!");
        jBClearFrameAttrib.setPreferredSize(new java.awt.Dimension(90, 32));
        jBClearFrameAttrib.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBClearFrameAttribActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPFrameButtons.add(jBClearFrameAttrib, gridBagConstraints);

        jPFrameAttribButtons.setBackground(new java.awt.Color(255, 255, 255));
        jPFrameAttribButtons.setBorder(javax.swing.BorderFactory.createTitledBorder(Constants.FRAME_ATTRIBUTES_TEXT));
        jPFrameAttribButtons.setLayout(new java.awt.GridBagLayout());

        jBAddFrameAttrib.setBackground(new java.awt.Color(255, 255, 255));
        jBAddFrameAttrib.setText("Add");
        jBAddFrameAttrib.setToolTipText("Add a new attribute, under the selected attribute.");
        jBAddFrameAttrib.setPreferredSize(new java.awt.Dimension(90, 32));
        jBAddFrameAttrib.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAddFrameAttribActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPFrameAttribButtons.add(jBAddFrameAttrib, gridBagConstraints);

        jTFFrameAttribName.setBackground(new java.awt.Color(255, 255, 255));
        jTFFrameAttribName.setPreferredSize(new java.awt.Dimension(200, 24));
        jTFFrameAttribName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFFrameAttribNameKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.01;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPFrameAttribButtons.add(jTFFrameAttribName, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPFrameButtons.add(jPFrameAttribButtons, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LAST_LINE_START;
        jPFrameAttrib.add(jPFrameButtons, gridBagConstraints);

        jTPAttributes.addTab(TAB_FRAME, jPFrameAttrib);

        jPObjectDefinition.setBackground(new java.awt.Color(255, 255, 255));
        jPObjectDefinition.setLayout(new java.awt.GridBagLayout());

        jPObjAttributesDefinition.setBackground(new java.awt.Color(255, 255, 255));
        jPObjAttributesDefinition.setLayout(new java.awt.GridBagLayout());

        jPObjAttribPreviewTree.setBackground(new java.awt.Color(255, 255, 255));
        jPObjAttribPreviewTree.setPreferredSize(new java.awt.Dimension(200, 320));
        jPObjAttribPreviewTree.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 0.01;
        gridBagConstraints.weighty = 0.01;
        jPObjAttributesDefinition.add(jPObjAttribPreviewTree, gridBagConstraints);

        jPObjButtons.setBackground(new java.awt.Color(255, 255, 255));
        jPObjButtons.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPObjButtons.setLayout(new java.awt.GridBagLayout());

        jBRemoveObjAttrib.setBackground(new java.awt.Color(255, 255, 255));
        jBRemoveObjAttrib.setText("Remove");
        jBRemoveObjAttrib.setToolTipText("Removes the selected attributes.");
        jBRemoveObjAttrib.setPreferredSize(new java.awt.Dimension(90, 32));
        jBRemoveObjAttrib.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRemoveObjAttribActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.weightx = 0.01;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPObjButtons.add(jBRemoveObjAttrib, gridBagConstraints);

        jBClearObjAttrib.setBackground(new java.awt.Color(255, 255, 255));
        jBClearObjAttrib.setText("Clear All");
        jBClearObjAttrib.setToolTipText("Removes ALL the attributes!");
        jBClearObjAttrib.setPreferredSize(new java.awt.Dimension(90, 32));
        jBClearObjAttrib.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBClearObjAttribActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPObjButtons.add(jBClearObjAttrib, gridBagConstraints);

        jPObjAttribButtons.setBackground(new java.awt.Color(255, 255, 255));
        jPObjAttribButtons.setBorder(javax.swing.BorderFactory.createTitledBorder(Constants.OBJECT_ATTRIBUTES_TEXT));
        jPObjAttribButtons.setLayout(new java.awt.GridBagLayout());

        jBAddObjAttrib.setBackground(new java.awt.Color(255, 255, 255));
        jBAddObjAttrib.setText("Add");
        jBAddObjAttrib.setToolTipText("Add a new attribute, under the selected attribute.");
        jBAddObjAttrib.setPreferredSize(new java.awt.Dimension(90, 32));
        jBAddObjAttrib.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAddObjAttribActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPObjAttribButtons.add(jBAddObjAttrib, gridBagConstraints);

        jTFObjAttribName.setBackground(new java.awt.Color(255, 255, 255));
        jTFObjAttribName.setPreferredSize(new java.awt.Dimension(200, 24));
        jTFObjAttribName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFObjAttribNameKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.01;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPObjAttribButtons.add(jTFObjAttribName, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPObjButtons.add(jPObjAttribButtons, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LAST_LINE_START;
        jPObjAttributesDefinition.add(jPObjButtons, gridBagConstraints);

        jPObjAttribExpand.setBackground(new java.awt.Color(255, 255, 255));
        jPObjAttribExpand.setLayout(new java.awt.GridBagLayout());

        jBObjExpand.setBackground(new java.awt.Color(255, 255, 255));
        jBObjExpand.setText("+");
        jBObjExpand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBObjExpandActionPerformed(evt);
            }
        });
        jPObjAttribExpand.add(jBObjExpand, new java.awt.GridBagConstraints());

        jBObjCollapse.setBackground(new java.awt.Color(255, 255, 255));
        jBObjCollapse.setText("-");
        jBObjCollapse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBObjCollapseActionPerformed(evt);
            }
        });
        jPObjAttribExpand.add(jBObjCollapse, new java.awt.GridBagConstraints());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        jPObjAttributesDefinition.add(jPObjAttribExpand, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 0.01;
        gridBagConstraints.weighty = 0.01;
        jPObjectDefinition.add(jPObjAttributesDefinition, gridBagConstraints);

        jTPAttributes.addTab(TAB_OBJECT, jPObjectDefinition);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 0.01;
        gridBagConstraints.weighty = 0.01;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 5, 10);
        jPContainer.add(jTPAttributes, gridBagConstraints);

        jBSaveAttributes.setBackground(new java.awt.Color(255, 255, 255));
        jBSaveAttributes.setText("Save");
        jBSaveAttributes.setToolTipText("Saves and applies the attributes.");
        jBSaveAttributes.setPreferredSize(new java.awt.Dimension(90, 32));
        jBSaveAttributes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSaveAttributesActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 10);
        jPContainer.add(jBSaveAttributes, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.01;
        gridBagConstraints.weighty = 0.01;
        getContentPane().add(jPContainer, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBSaveAttributesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSaveAttributesActionPerformed
        saveAttributes();
    }//GEN-LAST:event_jBSaveAttributesActionPerformed

    private void jBAddObjAttribActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAddObjAttribActionPerformed
        addNewObjectNode();
    }//GEN-LAST:event_jBAddObjAttribActionPerformed

    private void jBRemoveObjAttribActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRemoveObjAttribActionPerformed
        objTreePanel.removeCurrentNode();
    }//GEN-LAST:event_jBRemoveObjAttribActionPerformed

    private void jBClearObjAttribActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBClearObjAttribActionPerformed
        if (JOptionPane.YES_OPTION == Messages.showWarningYesNoMessager(this,
                "Are you sure you want to clear all the object attributes?\n(The root node will not be removed.)",
                "Attention!!")) {
            objTreePanel.clear();
        }
    }//GEN-LAST:event_jBClearObjAttribActionPerformed

    private void jTFObjAttribNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFObjAttribNameKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            addNewObjectNode();
        }
    }//GEN-LAST:event_jTFObjAttribNameKeyReleased

    private void jBObjExpandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBObjExpandActionPerformed
        objTreePanel.expandRows();
    }//GEN-LAST:event_jBObjExpandActionPerformed

    private void jBObjCollapseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBObjCollapseActionPerformed
        objTreePanel.collapseRows();
    }//GEN-LAST:event_jBObjCollapseActionPerformed

    private void jBFrameExpandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBFrameExpandActionPerformed
        frameTreePanel.expandRows();
    }//GEN-LAST:event_jBFrameExpandActionPerformed

    private void jBFrameCollapseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBFrameCollapseActionPerformed
        frameTreePanel.collapseRows();
    }//GEN-LAST:event_jBFrameCollapseActionPerformed

    private void jBRemoveFrameAttribActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRemoveFrameAttribActionPerformed
        // do not add a node if it is wanted to be the child of the root node or
        for (String attribute : FRAME_ATTRIBUTE_NAMES) {
            if (frameTreePanel.getSelection().equalsIgnoreCase(attribute)) {
                // Either one of the main attributes, or the root was selected.
                Toolkit.getDefaultToolkit().beep();
                return;
            }
        }

        frameTreePanel.removeCurrentNode();
    }//GEN-LAST:event_jBRemoveFrameAttribActionPerformed

    private void jBClearFrameAttribActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBClearFrameAttribActionPerformed
        if (JOptionPane.YES_OPTION == Messages.showWarningYesNoMessager(this,
                "Are you sure you want to clear all the frame attributes?\n(The main tree structure cannot be changed; it will not be removed.)",
                "Attention!!")) {
            clearFrameAttributes();
        }
    }//GEN-LAST:event_jBClearFrameAttribActionPerformed

    private void jBAddFrameAttribActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAddFrameAttribActionPerformed
        addNewFrameNode();
    }//GEN-LAST:event_jBAddFrameAttribActionPerformed

    private void jTFFrameAttribNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFFrameAttribNameKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            addNewFrameNode();
        }
    }//GEN-LAST:event_jTFFrameAttribNameKeyReleased

    private void jTPAttributesStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTPAttributesStateChanged
        // change the focus to the correct tab
        requestFocusedComponent();
    }//GEN-LAST:event_jTPAttributesStateChanged

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        closeWindow();
    }//GEN-LAST:event_formWindowClosing

    /**
     * Switches the tabbed pane to the wanted tab, specified by the name.
     *
     * @param tabName the name of the tab where it should change
     */
    public void switchToTab(String tabName) {
        int screenTabIndex = 0;

        // search for the index of the wanted tab in the list of tabs
        for (int index = 0; index < jTPAttributes.getTabCount(); index++) {
            if (tabName.equals(jTPAttributes.getTitleAt(index))) {
                screenTabIndex = index;
            }
        }

        // switch to the wanted tab
        jTPAttributes.setSelectedIndex(screenTabIndex);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AttributesDefinition.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new AttributesDefinition(null, null, null).setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAddFrameAttrib;
    private javax.swing.JButton jBAddObjAttrib;
    private javax.swing.JButton jBClearFrameAttrib;
    private javax.swing.JButton jBClearObjAttrib;
    private javax.swing.JButton jBFrameCollapse;
    private javax.swing.JButton jBFrameExpand;
    private javax.swing.JButton jBObjCollapse;
    private javax.swing.JButton jBObjExpand;
    private javax.swing.JButton jBRemoveFrameAttrib;
    private javax.swing.JButton jBRemoveObjAttrib;
    private javax.swing.JButton jBSaveAttributes;
    private javax.swing.JPanel jPContainer;
    private javax.swing.JPanel jPFrameAttrib;
    private javax.swing.JPanel jPFrameAttribButtons;
    private javax.swing.JPanel jPFrameAttribExpand;
    private javax.swing.JPanel jPFrameAttribPreviewTree;
    private javax.swing.JPanel jPObjAttribButtons;
    private javax.swing.JPanel jPObjAttribExpand;
    private javax.swing.JPanel jPObjAttribPreviewTree;
    private javax.swing.JPanel jPObjAttributesDefinition;
    private javax.swing.JTextField jTFFrameAttribName;
    private javax.swing.JTextField jTFObjAttribName;
    private javax.swing.JTabbedPane jTPAttributes;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
        // update the border of the panel where new attributes are added, with the data from the selected node  
        if (objTreePanel != null) {
            ((TitledBorder) jPObjAttribButtons.getBorder()).setTitle(objTreePanel.getSelection());
            jPObjAttribButtons.repaint();
        }

        if (frameTreePanel != null) {
            ((TitledBorder) jPFrameAttribButtons.getBorder()).setTitle(frameTreePanel.getSelection());
            jPFrameAttribButtons.repaint();
        }

        requestFocusedComponent();
    }

    /**
     * Add new node in the object attributes tree.
     */
    private void addNewObjectNode() {
        objTreePanel.addObject(jTFObjAttribName.getText());

        jTFObjAttribName.setText("");
        jTFObjAttribName.requestFocusInWindow();
    }

    /**
     * Add new node in the frame attributes tree.
     */
    private void addNewFrameNode() {
        // do not add a node if it is wanted to be the child of the root node or if it is the default invalid attribute
        if (frameTreePanel.getSelection().equalsIgnoreCase(Constants.FRAME_ATTRIBUTES_TEXT)) {
            // the root was selected and it should not be permited   
            Toolkit.getDefaultToolkit().beep();
            return;
        }

        frameTreePanel.addObject(jTFFrameAttribName.getText());

        jTFFrameAttribName.setText("");
        jTFFrameAttribName.requestFocusInWindow();
    }

    /**
     * Add the tree panel to the view and configure other gui components.
     */
    private void configureObjAttribTree() {
        // set the position of the tree panel
        java.awt.GridBagConstraints gbc = new java.awt.GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = java.awt.GridBagConstraints.BOTH;
        gbc.weightx = 0.01;
        gbc.weighty = 0.01;

        jPObjAttribPreviewTree.add(objTreePanel, gbc);
        objTreePanel.addObserver(this);

        // set the title of the panel
        TitledBorder titledBorder = BorderFactory.createTitledBorder(Constants.OBJECT_ATTRIBUTES_TEXT);
        jPObjAttribButtons.setBorder(titledBorder);

        objTreePanel.selectRoot();

        objTreePanel.expandRows();
    }

    /**
     * Save the defined attributes.
     */
    private void saveAttributes() {
        // write the user attributes to file
        saveObjectAttributes();
        saveFrameAttributes();

        closeWindow();
    }

    /**
     * Saves into the object attributes file, the latest wishes of the user.
     */
    public void saveObjectAttributes() {
        try (FileOutputStream fout = new FileOutputStream(Constants.OBJECT_ATTRIBUTES_PATH);
                ObjectOutputStream oos = new ObjectOutputStream(fout)) {

            // write the user preferences object
            oos.writeObject(objTreePanel.getRootNode());

        } catch (IOException ex) {
            String msg = "Error while writing the object attributes to the file!";
            log.error(msg);
            log.debug("{} {}", msg, ex);
        }
    }

    /**
     * Saves into the object attributes file, the latest wishes of the user.
     */
    public void saveFrameAttributes() {
        try (BufferedWriter bwFrame = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(Constants.FRAME_ATTRIBUTES_PATH), Charset.forName("UTF-8")))) {
            bwFrame.write(getFrameAttributesString());
            bwFrame.flush();
        } catch (IOException ex) {
            String msg = "Error while writing the frame attributes to the file!";
            log.error(msg);
            log.debug("{} {}", msg, ex);
        }
    }

    /**
     * Set the object attributes from the application configuration.
     */
    private void loadObjectAttributes() {
        // create and add the components to the view
        populateObjTree();

        // display the tree in the proper place
        configureObjAttribTree();
    }

    /**
     * Add the tree panel to the view and configure other gui components.
     */
    private void configureFrameAttribTree() {
        // set the position of the tree panel
        java.awt.GridBagConstraints gbc = new java.awt.GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = java.awt.GridBagConstraints.BOTH;
        gbc.weightx = 0.01;
        gbc.weighty = 0.01;

        jPFrameAttribPreviewTree.add(frameTreePanel, gbc);
        frameTreePanel.addObserver(this);

        // set the title of the panel
        TitledBorder titledBorder = BorderFactory.createTitledBorder(Constants.FRAME_ATTRIBUTES_TEXT);
        jPFrameAttribButtons.setBorder(titledBorder);

        frameTreePanel.selectRoot();

        frameTreePanel.expandRows();
    }

    /**
     * Remove the frame attributes but keep the basic structure.
     */
    private void clearFrameAttributes() {
        // remove all the nodes of the root
        frameTreePanel.clear();

        // add the basic structure of the tree
        populateFrameTree(false);

        // expand the frame
        frameTreePanel.expandRows();
    }

    /**
     * Request the focus of the application for the input text component of the
     * active tab.
     */
    private void requestFocusedComponent() {
        int index = jTPAttributes.getSelectedIndex();

        // set the focus to the needed component
        switch (jTPAttributes.getTitleAt(index)) {
            case TAB_FRAME:
                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        jTFFrameAttribName.requestFocusInWindow();
                    }
                });
                break;

            case TAB_OBJECT:
                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        jTFObjAttribName.requestFocusInWindow();
                    }
                });
                break;

            default:
                jTFFrameAttribName.requestFocusInWindow();
                break;
        }
    }

    /**
     * Fill in the tree with predefined data, or load the existing data.
     */
    public void populateObjTree() {
        if (objectAttributes != null) {
            // if the object attributes is not null, load the existing data
            objTreePanel = new DynamicTree(objectAttributes, OBJ_ATTRIB_TREE_DEPTH);
        } else {
            // create a new predefined tree
            objectAttributes = new CustomTreeNode(Constants.OBJECT_ATTRIBUTES_TEXT);
            objTreePanel = new DynamicTree(objectAttributes, OBJ_ATTRIB_TREE_DEPTH);

            String p1Name = "Vehicles";
            String p2Name = "Traffic signs";
            String c11Name = "LKW";
            String c12Name = "PKW";
            String c21Name = "Prohibitory";
            String c22Name = "Speed limits";
            String c23Name = "Attention";

            CustomTreeNode p1 = objTreePanel.addObject(null, p1Name);
            CustomTreeNode p2 = objTreePanel.addObject(null, p2Name);

            objTreePanel.addObject(p1, c11Name);
            objTreePanel.addObject(p1, c12Name);

            objTreePanel.addObject(p2, c21Name);
            objTreePanel.addObject(p2, c22Name);
            objTreePanel.addObject(p2, c23Name);
        }
    }

    /**
     * Fill in the tree with predefined data, or load the existing data.
     *
     * @param addFrameAttrib true if the tree should be filled in with the
     * predefined frame attributes or false if just the structure of the tree
     * should be created
     */
    private void populateFrameTree(boolean addFrameAttrib) {
        if ((frameTreePanel == null) || (frameAttributes == null)) {
            frameAttributes = new CustomTreeNode(Constants.FRAME_ATTRIBUTES_TEXT);
            frameTreePanel = new DynamicTree(frameAttributes, FRAME_ATTRIB_TREE_DEPTH);
        }

        CustomTreeNode<String> illuminationNode = new CustomTreeNode<>(FRAME_ATTRIBUTE_NAMES[1]);
        CustomTreeNode<String> weatherNode = new CustomTreeNode<>(FRAME_ATTRIBUTE_NAMES[2]);
        CustomTreeNode<String> roadTypeNode = new CustomTreeNode<>(FRAME_ATTRIBUTE_NAMES[3]);
        CustomTreeNode<String> roadEventNode = new CustomTreeNode<>(FRAME_ATTRIBUTE_NAMES[4]);
        CustomTreeNode<String> countryNode = new CustomTreeNode<>(FRAME_ATTRIBUTE_NAMES[5]);

        frameAttributes.addChild(illuminationNode);
        frameAttributes.addChild(weatherNode);
        frameAttributes.addChild(roadTypeNode);
        frameAttributes.addChild(roadEventNode);
        frameAttributes.addChild(countryNode);

        // do not add the frame attributes if not wanted or if the data is invalid
        if ((frameAttribString == null) || (!addFrameAttrib)) {
            return;
        }

        // add the new attributes
        frameAttribString.getIlluminationList().stream()
                .forEach(illumination -> illuminationNode.addChild(illumination));

        frameAttribString.getWeatherList().stream()
                .forEach(weather -> weatherNode.addChild(weather));

        frameAttribString.getRoadTypeList().stream()
                .forEach(roadType -> roadTypeNode.addChild(roadType));

        frameAttribString.getRoadEventList().stream()
                .forEach(roadEvent -> roadEventNode.addChild(roadEvent));

        frameAttribString.getCountryList().stream()
                .forEach(country -> countryNode.addChild(country));
    }

    /**
     * Get the frame attributes in order to save them in a file.
     *
     * @return the string to be saved in the file
     */
    private String getFrameAttributesString() {
        StringBuilder frameAttrib = new StringBuilder();

        // put all the frame specific attributes
        frameAttrib.append("illumination=");
        frameAttrib.append(getFrameAttributes(frameTreePanel.getRootNode().getChild(FRAME_ATTRIBUTE_NAMES[1]).getChildren()));
        frameAttrib.append("weather=");
        frameAttrib.append(getFrameAttributes(frameTreePanel.getRootNode().getChild(FRAME_ATTRIBUTE_NAMES[2]).getChildren()));
        frameAttrib.append("road_type=");
        frameAttrib.append(getFrameAttributes(frameTreePanel.getRootNode().getChild(FRAME_ATTRIBUTE_NAMES[3]).getChildren()));
        frameAttrib.append("road_event=");
        frameAttrib.append(getFrameAttributes(frameTreePanel.getRootNode().getChild(FRAME_ATTRIBUTE_NAMES[4]).getChildren()));
        frameAttrib.append("country=");
        frameAttrib.append(getFrameAttributes(frameTreePanel.getRootNode().getChild(FRAME_ATTRIBUTE_NAMES[5]).getChildren()));

        return frameAttrib.toString();
    }

    /**
     * Build a string with the attributes of the frame, defined in the input
     * list.
     *
     * @param attributesList the list of attributes which has to be converted to
     * a string.
     * @return the string representing the frame attributes, separated by comma
     */
    private static String getFrameAttributes(List<Object> attributesList) {
        StringBuilder frameAttrib = new StringBuilder();
        for (Object attribute : attributesList) {
            frameAttrib.append(attribute);
            frameAttrib.append(",");
        }
        return frameAttrib.substring(0, frameAttrib.length() - 1) + "\r\n";
    }

    /**
     * Close the edit attributes window.
     */
    private void closeWindow() {
        // notify other components to reload attributes
        observable.notifyObservers(ObservedActions.Action.RELOAD_ATTRIBUTES);

        // close the frame
        dispose();
    }
}
