import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class GUI{
        static Gnoxi currentGnoxi;
        public Shop shop = new Shop();

        private JButton item1;
        private JButton item2;
        private JButton item3;
        private JButton item4;
        private JButton item5;
        private JButton item6;
        private JButton randPoop;
        private JLabel bowLabel;
        private JLabel gold;
        private ImageIcon shopBow2;
        private JFrame frame;

        public static void newGnoxi(){            //asks user to input name
                String nameQuery = JOptionPane.showInputDialog("Enter the name of your Gnoxi");
                Gnoxi currentGnoxi = new Gnoxi(nameQuery, 0, 100, 100, 0, 100, System.currentTimeMillis(), 500);      //creates new gnoxi
                FileIO.writeGnoxi(currentGnoxi);  //saves gnoxi to CSV
                new GUI(currentGnoxi);            //starts GUI
        }

        public static void oldGnoxi(){
                currentGnoxi=FileIO.createOldGnoxi();
                new GUI(currentGnoxi);
        }
        public void death(){

                int result = JOptionPane.showConfirmDialog(frame, "       Your Gnoxi has died \n        Start new game?","Death",
                        JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

                if(result == JOptionPane.YES_OPTION){
                        newGnoxi();
                        frame.dispose();

                }
                if (result == JOptionPane.NO_OPTION || result == JOptionPane.CLOSED_OPTION){
                        frame.dispose();
                        new Menu();
                }
        }
        public void addBow(){

        }
        public GUI(Gnoxi currentGnoxi) {
                this.currentGnoxi=currentGnoxi;

                //ICONS

                ImageIcon happinessIcon = new ImageIcon("Media/StatusBars/happiness.png");        //happiness
                ImageIcon hungerIcon = new ImageIcon("Media/StatusBars/hunger.png");              //hunger
                ImageIcon energyIcon = new ImageIcon("Media/StatusBars/energy.png");              //energy
                ImageIcon goldIcon = new ImageIcon("Media/ShopIcons/goldIcon.png");               //gold
                ImageIcon logoIcon = new ImageIcon("Media/gnoxiIcon.png");                        //logo
                ImageIcon gnoxiIcon = new ImageIcon(Gnoxi.gnoxiType());                                   //Gnoxi
                ImageIcon sleepIcon = new ImageIcon("Media/Interaction/sleepIcon.png");           //sleep
                ImageIcon gnoxiSleep= new ImageIcon("Media/Gnoxi/gnoxiSleep.png");                //sleepThingg
                ImageIcon poopIcon = new ImageIcon("Media/Gnoxi/gnoxiPoop.png");                  //poop
                ImageIcon foodIcon = new ImageIcon("Media/ShopIcons/foodIcon.png");               //food1
                ImageIcon energyDrinkIcon = new ImageIcon("Media/ShopIcons/energyDrinkIcon.png"); //energy drink
                ImageIcon shopBow = new ImageIcon("Media/ShopIcons/shopBow.png");                 //shop bow
                ImageIcon shopBow2 = new ImageIcon("Media/ShopIcons/shopBow2.png");               //shop bow2
                this.shopBow2 = shopBow2;

                ButtonHandler handler = new ButtonHandler();

                //BUTTONS

                JButton sleep = new JButton();
                sleep.setIcon(sleepIcon);
                sleep.setBackground(ColorUIResource.WHITE);
                sleep.setFocusPainted(false);

                //SHOP BUTTONS


                JButton item1 = new JButton();
                this.item1=item1;
                item1.setIcon(foodIcon);
                item1.setBackground(ColorUIResource.WHITE);
                item1.setVerticalTextPosition(JLabel.CENTER);
                item1.addActionListener(handler);
                item1.setText("Food: 5g");
                item1.setToolTipText("15+ food");
                item1.setFocusPainted(false);

                JButton item2 = new JButton();
                this.item2 = item2;
                item2.setBackground(ColorUIResource.WHITE);
                item2.setIcon(energyDrinkIcon);
                item2.setVerticalTextPosition(JLabel.CENTER);
                item2.addActionListener(handler);
                item2.setText("Drink: 15g");
                item2.setToolTipText("15+ energy");
                item2.setFocusPainted(false);

                JButton item3 = new JButton();
                this.item3 = item3;
                item3.addActionListener(handler);
                item3.setBackground(ColorUIResource.WHITE);
                item3.setFocusPainted(false);

                JButton item4 = new JButton();
                this.item4 = item4;
                item4.setBackground(ColorUIResource.WHITE);
                item4.setFocusPainted(false);

                JButton item5 = new JButton();
                this.item5 = item5;
                item5.setBackground(ColorUIResource.WHITE);
                item5.setIcon(shopBow);
                item5.setVerticalTextPosition(JLabel.CENTER);
                item5.addActionListener(handler);
                item5.setText("Bow: 500g");
                item5.setToolTipText("adds a pretty lil' bow");
                item5.setFocusPainted(false);

                JButton item6 = new JButton();
                this.item6 = item6;
                item6.setBackground(ColorUIResource.WHITE);
                item6.setFocusPainted(false);

                //LABELS

                JLabel gold = new JLabel();
                this.gold=gold;
                gold.setBorder(new EmptyBorder(20,0,20,0));
                gold.setSize(50,50);
                gold.setBackground(ColorUIResource.WHITE);
                gold.setText(currentGnoxi.getGold()+"g");
                gold.setVerticalTextPosition(JLabel.CENTER);
                gold.setFont(new Font("Arial", Font.BOLD, 20));
                gold.setIcon(goldIcon);


                JLabel gnoxi1 = new JLabel();                            //gnoxi label
                gnoxi1.setIcon(gnoxiIcon);
                gnoxi1.setText(currentGnoxi.getName()); //nameQuery
                gnoxi1.setVerticalTextPosition(JLabel.TOP);
                gnoxi1.setHorizontalTextPosition(JLabel.CENTER);


                JLabel hungerStat = new JLabel();                       //STATUS LABELS
                hungerStat.setText("Hunger");
                hungerStat.setFont(new Font("Arial", Font.BOLD, 12));
                //hungerStat.setIcon(hungerIcon);


                JLabel happinessStat = new JLabel();
                happinessStat.setText("Happiness");
                happinessStat.setFont(new Font("Arial", Font.BOLD, 12));
                //happinessStat.setIcon(happinessIcon);


                JLabel energyStat = new JLabel();
                energyStat.setText("Energy");
                energyStat.setFont(new Font("Arial", Font.BOLD, 12));
                //energyStat.setIcon(energyIcon);


                //PANELS

                JPanel Shop = new JPanel();
                Shop.setBackground(ColorUIResource.WHITE);//Shop panel
                Shop.setLayout(new GridLayout(6,1));
                Shop.add(item1);
                Shop.add(item2);
                Shop.add(item3);
                Shop.add(item4);
                Shop.add(item5);
                Shop.add(item6);



                JPanel StatusField = new JPanel();                          //Status field panel
                StatusField.setBackground(ColorUIResource.PINK);
                StatusField.setLayout(new GridBagLayout());
                GridBagConstraints a = new GridBagConstraints();
                a.insets = new Insets(5,40,0,40);
                a.anchor = GridBagConstraints.CENTER;
                a.gridx = 0;
                a.gridy = 0;
                StatusField.add(hungerStat,a);
                a.gridx = 1;
                a.gridy = 0;
                StatusField.add(happinessStat,a);
                a.gridx = 2;
                a.gridy = 0;
                StatusField.add(energyStat,a);


                JLabel hungerLabel = new JLabel();
                hungerLabel.setIcon(hungerIcon);
                hungerLabel.setOpaque(false);
                JProgressBar progressBar = new JProgressBar();
                progressBar.setOpaque(false);
                progressBar.setMaximum(100);
                progressBar.setOrientation(JProgressBar.VERTICAL);
                progressBar.setPreferredSize(new Dimension(40, 40));

                JLabel happinessLabel = new JLabel();
                happinessLabel.setIcon(happinessIcon);
                happinessLabel.setOpaque(false);
                JProgressBar progressBar2 = new JProgressBar();
                progressBar2.setOpaque(false);
                progressBar2.setOrientation(JProgressBar.VERTICAL);
                progressBar2.setPreferredSize(new Dimension(40, 40));

                JLabel energyLabel = new JLabel();
                energyLabel.setIcon(energyIcon);
                energyLabel.setOpaque(false);
                JProgressBar progressBar3 = new JProgressBar();
                progressBar3.setOpaque(false);
                progressBar3.setOrientation(JProgressBar.VERTICAL);
                progressBar3.setPreferredSize(new Dimension(40, 40));

                // Add the progress bar to a container
                Container container = StatusField;
                a.gridx = 0;
                a.gridy = 1;
                container.add(hungerLabel,a);
                container.add(progressBar,a);
                a.gridx = 1;
                a.gridy = 1;
                container.add(happinessLabel,a);
                container.add(progressBar2,a);
                a.gridx = 2;
                a.gridy = 1;
                container.add(energyLabel,a);
                container.add(progressBar3,a);

                // Create a new thread for the incrementing function
                Thread incrementThread = new Thread(() -> {

                        int hunger= currentGnoxi.getHunger();


                        while (currentGnoxi.getHunger()>0) {
                                currentGnoxi.setHunger(currentGnoxi.getHunger()-1);

                                progressBar.setValue(currentGnoxi.getHunger());
                                if(currentGnoxi.getHunger()==0){
                                        death();
                                }
                                else if (hunger < 30) {
                                        progressBar.setForeground(Color.RED);
                                } else if (hunger > 30 && hunger < 60){
                                        progressBar.setForeground(Color.yellow);
                                }
                                else{
                                        progressBar.setForeground(Color.green);
                                }

                                try {
                                        Thread.sleep(1000); // real milis 2592000
                                } catch (InterruptedException e) {
                                        // If the thread is interrupted, break out of the loop
                                        break;
                                }
                        }

                });

                incrementThread.start();
                Thread incrementThread2 = new Thread(() -> {
                        int happiness = currentGnoxi.getHappiness();

                        while (currentGnoxi.getHappiness()>0) {
                                currentGnoxi.setHappiness(currentGnoxi.getHappiness()-1);

                                progressBar2.setValue(currentGnoxi.getHappiness());
                                if(currentGnoxi.getHappiness()==0){
                                        death();
                                }
                                if (happiness < 30) {
                                        progressBar2.setForeground(Color.RED);
                                } else if (happiness > 30 && happiness < 60){
                                        progressBar2.setForeground(Color.yellow);
                                }
                                else{
                                        progressBar2.setForeground(Color.green);
                                }

                                try {
                                        Thread.sleep(10000); // Pause the thread for 10 seconds
                                } catch (InterruptedException e) {
                                        // If the thread is interrupted, break out of the loop
                                        break;
                                }
                        }

                });
                incrementThread2.start();

                Thread incrementThread3 = new Thread(() -> {
                        int energy= currentGnoxi.getEnergy();
                        while (currentGnoxi.getEnergy()>0) {
                                currentGnoxi.setEnergy(currentGnoxi.getEnergy()-1);
                                if(currentGnoxi.getEnergy()==0){
                                        death();
                                }
                                progressBar3.setValue(currentGnoxi.getEnergy());
                                if (energy < 30) {
                                        progressBar3.setForeground(Color.RED);
                                } else if (energy > 30 && energy < 60){
                                        progressBar3.setForeground(Color.yellow);
                                }
                                else{
                                        progressBar3.setForeground(Color.green);
                                }

                                try {
                                        Thread.sleep(1000); // Pause the thread for 10 seconds
                                } catch (InterruptedException e) {
                                        // If the thread is interrupted, break out of the loop
                                        break;
                                }
                        }

                });

                incrementThread3.start();


                JLabel bowLabel = new JLabel();
                this.bowLabel = bowLabel;
                bowLabel.setIcon(new ImageIcon("Media/Gnoxi/gnoxiBow.png"));
                bowLabel.setVisible(false);
                JPanel gnoxi = new JPanel();
                //Gnoxi panel
                gnoxi.setLayout(new GridBagLayout());
                GridBagConstraints q = new GridBagConstraints();
                gnoxi.setBackground(ColorUIResource.PINK);
                q.gridx = 0;
                q.gridy = 0;
                gnoxi.add(bowLabel,q);
                gnoxi.add(gnoxi1,q);
                gnoxi.setBorder(new EmptyBorder(20,0,0,0));

                JPanel Interaction = new JPanel();                          //Interaction panel
                Interaction.setBackground(ColorUIResource.PINK);
                Interaction.setBorder(new EmptyBorder(0,0,0,200));
                Interaction.add(sleep);
                Interaction.setLayout(new FlowLayout(FlowLayout.LEFT,50,0));


                JPanel GnoxiPanel = new JPanel();
                GnoxiPanel.setLayout(new GridBagLayout());
                GnoxiPanel.setBackground(ColorUIResource.PINK);
                GridBagConstraints d = new GridBagConstraints();
                GnoxiPanel.setBorder(new EmptyBorder(20,10,17,10));
                d.weighty = 0.1;
                d.fill = GridBagConstraints.VERTICAL;
                d.gridx = 0;
                d.gridy = 1;
                GnoxiPanel.add(StatusField,d);
                d.weighty = 0.5;
                d.fill = GridBagConstraints.VERTICAL;
                d.gridx = 0;
                d.gridy = 2;
                d.ipady=40;
                GnoxiPanel.add(gnoxi,d);
                d.ipady=10;
                d.weighty = 0.1;
                d.fill = GridBagConstraints.VERTICAL;
                d.gridx = 0;
                d.gridy = 3;
                GnoxiPanel.add(Interaction,d);


                //FRAME
                JFrame frame = new JFrame("GnoxiWorld");               //Main frame
                this.frame = frame;
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(700, 500);
                frame.setLocationRelativeTo(null);
                frame.setIconImage(logoIcon.getImage());
                frame.setResizable(false);
                frame.setVisible(true);
                frame.setLayout(new GridBagLayout());
                GridBagConstraints c = new GridBagConstraints();
                c.weightx = 0.5;
                c.weighty = 1;
                c.fill = GridBagConstraints.HORIZONTAL;
                c.gridx = 0;
                c.gridheight=5;
                frame.add(GnoxiPanel,c);
                c.gridheight=1;
                c.weighty = 0;
                c.weightx = 0.1;
                c.gridx = 3;
                c.gridy = 1;
                c.fill = GridBagConstraints.HORIZONTAL;
                frame.add(Shop,c);
                c.gridy = 0;
                d.ipady=0;
                c.gridx = 3;
                c.fill = GridBagConstraints.CENTER;
                frame.add(gold,c);



                Random randomX = new Random();
                int xMax = 700;
                int int_randomX = randomX.nextInt(xMax);
                System.out.println((xMax - 1) + int_randomX);
                int poopPosX = xMax - 1 + int_randomX;

                Random randomY = new Random();
                int yMax = 500;
                int int_randomY = randomY.nextInt(yMax);
                System.out.println((yMax - 1) + int_randomY);
                int poopPosY = yMax - 1 + int_randomY;

                //X 700 Y 500
                JButton randPoop = new JButton();
                this.randPoop = randPoop;
                randPoop.setIcon(poopIcon);
                randPoop.setBorderPainted(false);
                randPoop.setBackground(ColorUIResource.PINK);
                randPoop.setFocusPainted(false);
                randPoop.setContentAreaFilled(false);
                randPoop.setLayout(null);
                randPoop.setBounds(poopPosX,poopPosY,30,30);
                randPoop.repaint();
                randPoop.addActionListener(handler);
                frame.add(randPoop);

        }

        private class ButtonHandler implements ActionListener {
                public void actionPerformed(ActionEvent e) {

                        if (e.getSource() == randPoop){
                                currentGnoxi.setGold(currentGnoxi.gold +=10);
                                randPoop.setVisible(false);
                        }

                        if (e.getSource() == item1) {

                                if (currentGnoxi.getHunger() == 100){
                                        System.out.println("Gnoxi is full");
                                }
                                if(!shop.buy(1)){
                                        JOptionPane.showMessageDialog(item1,"You dont have enough gold","Shop", JOptionPane.ERROR_MESSAGE);
                                }

                                else if (currentGnoxi.getHunger()+15 > 100){
                                        currentGnoxi.setHunger(100);
                                        System.out.println(currentGnoxi.getHunger());
                                        
                                }

                                else {
                                        shop.buy(1);
                                        currentGnoxi.setHunger(currentGnoxi.getHunger()+15);
                                }
                        }
                        if (e.getSource() == item2) {
                                shop.buy(2);

                                if (currentGnoxi.getEnergy() == 100){
                                        System.out.println("Gnoxi is fully energized");
                                }

                                else if(!shop.buy(2)){
                                        JOptionPane.showMessageDialog(item2,"You dont have enough gold","Shop", JOptionPane.ERROR_MESSAGE);
                                }
                                else if (currentGnoxi.getEnergy()+15 > 100){
                                        currentGnoxi.setEnergy(100);
                                        System.out.println(currentGnoxi.getEnergy());
                                        shop.buy(1);
                                }
                                else {
                                        shop.buy(1);
                                        currentGnoxi.setEnergy(currentGnoxi.getEnergy()+15);
                                }
                        }
                        if (e.getSource() == item3) {
                                //shop.buy(3);
                                death();

                        }
                        if (e.getSource() == item4) {
                                shop.buy(4);

                        }
                        if (e.getSource() == item5) {
                                if(!shop.buy(5)){
                                        JOptionPane.showMessageDialog(item5,"You dont have enough gold","Shop", JOptionPane.ERROR_MESSAGE);
                                }
                                else {
                                        if (bowLabel.isVisible()){
                                                JOptionPane.showMessageDialog(item5,"Already owned","Shop", JOptionPane.ERROR_MESSAGE);
                                                return;
                                        }
                                        else {
                                                shop.buy(5);
                                                item5.setOpaque(false);
                                                item5.setIcon(shopBow2);
                                                item5.repaint();
                                                bowLabel.setVisible(true);
                                        }

                                }
                        }
                        if (e.getSource() == item6) {
                                shop.buy(6);
                        }

                        gold.setText(currentGnoxi.getGold()+"g");
                }
        }

}