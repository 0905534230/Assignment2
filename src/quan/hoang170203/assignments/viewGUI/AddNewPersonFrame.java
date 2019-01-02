package quan.hoang170203.assignments.viewGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddNewPersonFrame extends JFrame {
	
		private static ArrayList<JPanel> panels = new ArrayList<>();
		private static JFrame frame;
		
    public AddNewPersonFrame(int typesOfEmployee , int id , boolean isEdited) {
    	
    	panels.clear();
    	frame = this;
    	
    	
        setSize(400, 500);
        setTitle("Dialog");
        setLayout(null);

        PanelTop panelTop = new PanelTop();
        panelTop.setBounds(0, 0, 400, 90);
        
        PanelMiddle panelMiddle = new PanelMiddle();
        panelMiddle.setBounds(0, 100, 400, 80);
        
        PanelBottomLecturer panelBottomLecturer = new PanelBottomLecturer();
        panelBottomLecturer.setBounds(0, 180, 400, 400);
        panelBottomLecturer.setVisible(false);
        
        PanelBottomStaff panelBottomStaff = new PanelBottomStaff();
        panelBottomStaff.setBounds(0, 180, 400, 400);
        panelBottomStaff.setVisible(false);
        
        PanelBottomCasualWorker panelBottomCasualWorker = new PanelBottomCasualWorker();
        panelBottomCasualWorker.setBounds(0, 180, 400, 400);
        panelBottomCasualWorker.setVisible(false);
        
        PanelButtonAction panelButtonAction = new PanelButtonAction(isEdited);
        panelButtonAction.setBounds(50 , 180, 400, 40 );
        panelButtonAction.setVisible(true);
        
        this.add(panelTop);
        this.add(panelMiddle);
        this.add(panelBottomLecturer);
        this.add(panelBottomStaff);
        this.add(panelBottomCasualWorker);
        this.add(panelButtonAction);
        
        
        panels.add(panelTop);
        panels.add(panelMiddle);
        panels.add(panelBottomLecturer);
        panels.add(panelBottomStaff);
        panels.add(panelBottomCasualWorker);
        panels.add(panelButtonAction);
    }

    public static void showPanelMiddleandPanelBottom(int typesOfEmployee){
    	switch(typesOfEmployee) {
    	case 0 :{
    		
    		panels.get(2).setVisible(true);
    		panels.get(3).setVisible(false);
    		panels.get(4).setVisible(false);
    		panels.get(5).setLocation(panels.get(2).getLocation().x, (int) (panels.get(2).getLocation().y + panels.get(2).getSize().getHeight()));
            break;
    
    	}
    	case 1: {
    		
    		panels.get(2).setVisible(false);
    		panels.get(3).setVisible(true);
    		panels.get(4).setVisible(false);
    		panels.get(5).setLocation(panels.get(3).getLocation().x, (int) (panels.get(3).getLocation().y + panels.get(3).getSize().getHeight() + 20));
    		break;
    	}
    	case 2: {
    		
    		panels.get(2).setVisible(false);
    		panels.get(3).setVisible(false);
    		panels.get(4).setVisible(true);
    		panels.get(5).setLocation(panels.get(4).getLocation().x, (int) (panels.get(4).getLocation().y + panels.get(4).getSize().getHeight() +20));
    		break;
    	}
    	
    }
    	AddNewPersonFrame.frame.setSize(400, (int) (panels.get(5).getLocation().y + panels.get(5).getSize().getHeight() + 40));

    }
    
   class PanelTop extends JPanel{
	    String Type[] = {"Lecturer" ,"Staff" , "CasualWorker"};
	    
	    public PanelTop() {
	    	
		   this.setLayout(null);
		   
		   //id
		   	JLabel labelId = new JLabel("ID");
	        labelId.setLocation(20, 20);
	        labelId.setSize(labelId.getPreferredSize());
	        this.add(labelId);
	        
	        JTextField textFieldId = new JTextField();
	        textFieldId.setBounds(150,20,120,25);
	        this.add(textFieldId);
	        textFieldId.setText("1");
	        textFieldId.setEditable(false);
	        
	        // type
	        JLabel labelType = new JLabel("Type");
	        labelType.setLocation(20, 60);
	        labelType.setSize(labelType.getPreferredSize());
	        this.add(labelType);
	        
	        JComboBox cbType = new JComboBox(Type);
	        cbType.setBounds(150 , 60 , 120 , 25);
	        cbType.addActionListener(new ActionListener(){
	        
	        
	        	@Override
	        	public void actionPerformed(ActionEvent e) {
	        			AddNewPersonFrame.showPanelMiddleandPanelBottom(cbType.getSelectedIndex());
	        	}
	        	});
	        this.add(cbType);
	   }
   }
   
   class PanelMiddle extends JPanel{
	   public PanelMiddle() {
		 
		   this.setLayout(null);

		   	//name
	        JLabel labelName = new JLabel("Name");
	        labelName.setLocation(20 , 0);
	        labelName.setSize(labelName.getPreferredSize());
	        this.add(labelName);
	        
	        JTextField textFieldName = new JTextField();
	        textFieldName.setBounds(150, 0, 120, 25);
	        this.add(textFieldName);
	        
	        // yearOfbirth
	        JLabel labelyearOfBirth = new JLabel("yearOfBirth");
	        labelyearOfBirth.setLocation(20, 40);
	        labelyearOfBirth.setSize(labelyearOfBirth.getPreferredSize());
	        this.add(labelyearOfBirth);
	        
	        
	        JTextField textFieldYearOfBirth = new JTextField();
	        textFieldYearOfBirth.setBounds(150, 40, 120, 25);
	        this.add(textFieldYearOfBirth);
	   }
   }
   
   class PanelBottomLecturer extends JPanel{
       String Qualification[] = {"Bachelor" ,"Master" , "Doctor"};
       public PanelBottomLecturer() {
    	   
    	   this.setLayout(null);
    	   
    	   	//hometown
	        JLabel labelHomeTown = new JLabel("HomeTown");
	        labelHomeTown.setLocation(20 , 0);
	        labelHomeTown.setSize(labelHomeTown.getPreferredSize());
	        this.add(labelHomeTown);
	        
	        JTextField textFieldHomeTown = new JTextField();
	        textFieldHomeTown.setBounds(150, 0, 120, 25);
	        this.add(textFieldHomeTown);
	        
	        //Department
	        JLabel labelDepartment = new JLabel("Department");
	        labelDepartment.setLocation(20, 40);
	        labelDepartment.setSize(labelDepartment.getPreferredSize());
	        this.add(labelDepartment);
	        
	        JTextField textFieldDepartment = new JTextField();
	        textFieldDepartment.setBounds(150, 40, 120, 25);
	        this.add(textFieldDepartment);
	        
	        //Qualification
	        JLabel labelQualification = new JLabel("Qualification");
	        labelQualification.setLocation(20,80);
	        labelQualification.setSize(labelQualification.getPreferredSize());
	        this.add(labelQualification);
	        
	        JComboBox cb = new JComboBox(Qualification);
	        cb.setBounds(150 , 80 , 120 , 25);
	        this.add(cb);

	        
	        //PeriodPerMonth
	        JLabel labelPeriodPerMonth = new JLabel("PeriodPerMonth");
	        labelPeriodPerMonth.setLocation(20, 120);
	        labelPeriodPerMonth.setSize(labelPeriodPerMonth.getPreferredSize());
	        this.add(labelPeriodPerMonth);
	        
	        JTextField textFieldPeriodPerMonth = new JTextField();
	        textFieldPeriodPerMonth.setBounds(150, 120, 120 , 25);
	        this.add(textFieldPeriodPerMonth);
	        
	        //SalaryRatio
	        JLabel labelSalaryRatio = new JLabel("SalaryRatio");
	        labelSalaryRatio.setLocation(20, 160);
	        labelSalaryRatio.setSize(labelSalaryRatio.getPreferredSize());
	        this.add(labelSalaryRatio);
	        
	        JTextField textFieldSalaryRatio = new JTextField();
	        textFieldSalaryRatio.setBounds(150, 160, 120 , 25);
	        this.add(textFieldSalaryRatio);
	        
	        //yearsOfWork
	        JLabel labelYearsOfWork = new JLabel("YearsOfWork");
	        labelYearsOfWork.setLocation(20, 200);
	        labelYearsOfWork.setSize(labelYearsOfWork.getPreferredSize());
	        this.add(labelYearsOfWork);
	        
	        JTextField textFieldYearsOfWork = new JTextField();
	        textFieldYearsOfWork.setBounds(150, 200, 120 , 25);
	        this.add(textFieldYearsOfWork);
	        
	    }		
   }
    class PanelBottomStaff extends JPanel {
		
		public PanelBottomStaff() {
		    String Qualification[] = {"Chief" ,"Deputy" , "Employee"};
		    
		    this.setLayout(null);
		    
		    
		    //HomeTown
		    JLabel labelHomeTown = new JLabel("HomeTown");
		    labelHomeTown.setLocation(20 , 0);
		    labelHomeTown.setSize(labelHomeTown.getPreferredSize());
		    this.add(labelHomeTown);
		    
		    JTextField textFieldHomeTown = new JTextField();
		    textFieldHomeTown.setBounds(150,0,120,25);
		    this.add(textFieldHomeTown);
		    
		    //Department
		    JLabel labelDepartment = new JLabel("Department");
		    labelDepartment.setLocation(20, 40);
		    labelDepartment.setSize(labelDepartment.getPreferredSize());
		    this.add(labelDepartment);
		    
		    JTextField textFieldDepartment = new JTextField();
		    textFieldDepartment.setBounds(150, 40, 120, 25);
		    this.add(textFieldDepartment);
		    
		    //WorkDay
		    JLabel labelWorkDay = new JLabel("WorkDay");
		    labelWorkDay.setLocation(20,80);
		    labelWorkDay.setSize(labelWorkDay.getPreferredSize());
		    this.add(labelWorkDay);
		    
		    JTextField textFieldWorkDay = new JTextField();
		    textFieldWorkDay.setBounds(150, 80, 120, 25);
		    this.add(textFieldWorkDay);
		    
		    //SalaryRatio
		    JLabel labelSalaryRatio = new JLabel("SalaryRatio");
		    labelSalaryRatio.setLocation(20 , 120);
		    labelSalaryRatio.setSize(labelSalaryRatio.getPreferredSize());
		    this.add(labelSalaryRatio);
		    
		    JTextField textFieldSalaryRatio = new JTextField();
		    textFieldSalaryRatio.setBounds(150 , 120 , 120 , 25);
		    this.add(textFieldSalaryRatio);
		    
		    //Position
		    JLabel labelPosition = new JLabel("Position");
		    labelPosition.setLocation(20 , 160);
		    labelPosition.setSize(labelPosition.getPreferredSize());
		    this.add(labelPosition);
		    

		    JComboBox cb = new JComboBox(Qualification);
		    cb.setBounds(150 , 160 , 120 , 25);
		    this.add(cb);
		    
		    //YearsOfWork
		    JLabel labelYearsOfWork = new JLabel("YearsOfWork");
		    labelYearsOfWork.setLocation(20 , 200);
		    labelYearsOfWork.setSize(labelYearsOfWork.getPreferredSize());
		    this.add(labelYearsOfWork);
		    
		    JTextField textFieldYearsOfWork = new JTextField();
		    textFieldYearsOfWork.setBounds(150 , 200 , 120 , 25);
		    this.add(textFieldYearsOfWork);
		    
		}
       }
   class PanelBottomCasualWorker extends JPanel{
	   public PanelBottomCasualWorker(){
		   this.setLayout(null);

           JLabel labelWorkDay = new JLabel("WorkDay");
           labelWorkDay.setLocation(20 , 0);
           labelWorkDay.setSize(labelWorkDay.getPreferredSize());
           this.add(labelWorkDay);
           
           JTextField textFieldWorkDay = new JTextField();
           textFieldWorkDay.setBounds(150 , 0 , 120 , 25);
           this.add(textFieldWorkDay);
           
           JLabel labelPriceOfWorkDay = new JLabel("PriceOfWorkDay");
           labelPriceOfWorkDay.setLocation(20 , 40);
           labelPriceOfWorkDay.setSize(labelPriceOfWorkDay.getPreferredSize());
           this.add(labelPriceOfWorkDay);
           
           JTextField textFieldPriceOfWorkDay = new JTextField();
           textFieldPriceOfWorkDay.setBounds(150 , 40 , 120 , 25);
           this.add(textFieldPriceOfWorkDay);
	   } 
   }
   class PanelButtonAction extends JPanel{
	   public PanelButtonAction(boolean isEdited) {
		   this.setLayout(null);
		   
		   JButton actionButton = new JButton();
		   actionButton.setText("Update");
		   actionButton.setLocation(20 , 0);
		   actionButton.setSize(100 , 40);
		   
		   this.add(actionButton);
	   }
   }
}

   


