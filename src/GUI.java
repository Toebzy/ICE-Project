import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class GUI{
        static Gnoxi currentGnoxi;
        private final JLabel sleepLabel;
        private final JLabel gnoxiDie;
        private JProgressBar progressBar;
        private JProgressBar progressBar2;
        private JProgressBar progressBar3;
        private JPanel shopPanel;
        private JPanel GnoxiPanel;
        private JPanel gnoxi;
        public Shop shop = new Shop();

        private JButton item1;
        private JButton item2;
        private JButton item3;
        private JButton item4;
        private JButton item5;
        private JButton item6;
        private JButton randPoop;
        private JButton sleep;
        private JButton menuBack;
        private JButton aboutInfo;
        private JLabel bowLabel;
        private JLabel tophatLabel;
        private JLabel scarfLabel;
        private JLabel gold;

        private ImageIcon shopBow2;
        private ImageIcon scarfIcon2;
        private ImageIcon topHatIcon2;
        private JFrame frame;


        public static void newGnoxi(){            //asks user to input name
                String nameQuery = JOptionPane.showInputDialog("Enter the name of your Gnoxi");
                if(nameQuery == null || (nameQuery != null && ("".equals(nameQuery))))
                {
                        new Menu();
                }
                else {
                        Gnoxi currentGnoxi = new Gnoxi(nameQuery, 0, 100, 100, 100, System.currentTimeMillis(), 500, false, Gnoxi.gnoxiType(), false, false, false);      //creates new gnoxi
                        FileIO.writeGnoxi(currentGnoxi);  //saves gnoxi to CSV
                        new GUI(currentGnoxi);            //starts GUI
                }


        }

        public static void oldGnoxi(){
                currentGnoxi=FileIO.createOldGnoxi();
                new GUI(currentGnoxi);
        }
        public void death(){
                Gnoxi.save();
                gnoxiDie.setVisible(true);
                int result = JOptionPane.showConfirmDialog(item3, "Your Gnoxi has died, it was alive for " +
                                Calculator.calcAge(currentGnoxi.getAge())+
                                " days \n                 Start new game?", "Death",
                                JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

                if(result == JOptionPane.YES_OPTION){
                        newGnoxi();
                        frame.dispose();
                }
                if (result == JOptionPane.NO_OPTION || result == JOptionPane.CLOSED_OPTION){
                        new Menu();
                        frame.dispose();
                }
                frame.dispose();
        }
        public GUI(Gnoxi currentGnoxi) {
                this.currentGnoxi=currentGnoxi;


                if(Menu.onOff == 1) {
                        Menu.musicPlayer("Cascade");
                }

                //ICONS

                ImageIcon happinessIcon = new ImageIcon("Media/StatusBars/happiness.png");         //happiness
                ImageIcon hungerIcon = new ImageIcon("Media/StatusBars/hunger.png");               //hunger
                ImageIcon energyIcon = new ImageIcon("Media/StatusBars/energy.png");               //energy
                ImageIcon goldIcon = new ImageIcon("Media/ShopIcons/goldIcon.png");                //gold
                ImageIcon logoIcon = new ImageIcon("Media/gnoxiIcon.png");                         //logo
                ImageIcon gnoxiIcon = new ImageIcon("Media/Gnoxi/"+currentGnoxi.gnoxiType+".png"); //Gnoxi
                ImageIcon gnoxiTophat = new ImageIcon("Media/Gnoxi/gnoxiTophat.png");              //Gnoxi top hat
                ImageIcon gnoxiScarf = new ImageIcon("Media/Gnoxi/gnoxiScarf.png");                //Gnoxi scarf
                ImageIcon sleepIcon = new ImageIcon("Media/Interaction/sleepIcon.png");            //sleep
                ImageIcon aboutIcon= new ImageIcon("Media/Interaction/aboutIcon.png");             //aboutInfo
                ImageIcon backIcon = new ImageIcon("Media/Interaction/backIcon.png");              //back to menu
                ImageIcon gnoxiSleep= new ImageIcon("Media/Gnoxi/gnoxiSleep.png");                 //sleepThingg
                ImageIcon poopIcon = new ImageIcon("Media/Gnoxi/gnoxiPoop.png");                   //poop
                ImageIcon foodIcon = new ImageIcon("Media/ShopIcons/foodIcon.png");                //food1
                ImageIcon energyDrinkIcon = new ImageIcon("Media/ShopIcons/energyDrinkIcon.png");  //energy drink
                ImageIcon shopBow = new ImageIcon("Media/ShopIcons/shopBow.png");                  //shop bow
                ImageIcon shopBow2 = new ImageIcon("Media/ShopIcons/shopBow2.png");                //shop bow2
                ImageIcon gnoxiDead= new ImageIcon("Media/Gnoxi/gnoxiDead.png");                   //dead
                ImageIcon lollipop= new ImageIcon("Media/ShopIcons/lollipop.png");                 //lollipop
                ImageIcon topHatIcon= new ImageIcon("Media/ShopIcons/topHatIcon.png");             //topHat
                ImageIcon topHatIcon2= new ImageIcon("Media/ShopIcons/topHatIcon2.png");           //topHat2
                ImageIcon scarfIcon= new ImageIcon("Media/ShopIcons/scarfIcon.png");               //scarf
                ImageIcon scarfIcon2= new ImageIcon("Media/ShopIcons/scarfIcon2.png");             //scarf2
                ImageIcon borderTest= new ImageIcon("Media/borderTest.png");                       //scarf

                this.scarfIcon2 = scarfIcon2;
                this.topHatIcon2 = topHatIcon2;
                this.shopBow2 = shopBow2;

                ButtonHandler handler = new ButtonHandler();

                //BUTTONS

                JButton sleep = new JButton();
                this.sleep = sleep;
                sleep.setIcon(sleepIcon);
                sleep.setBackground(ColorUIResource.WHITE);
                sleep.setFocusPainted(false);
                sleep.addActionListener(handler);

                aboutInfo = new JButton();
                aboutInfo.setIcon(aboutIcon);
                aboutInfo.setBackground(ColorUIResource.WHITE);
                aboutInfo.setOpaque(false);
                aboutInfo.setFocusPainted(false);
                aboutInfo.setBorderPainted(false);
                aboutInfo.addActionListener(handler);

                menuBack = new JButton();
                menuBack.setIcon(backIcon);
                menuBack.setBackground(ColorUIResource.WHITE);
                menuBack.setFocusPainted(false);
                menuBack.setBorderPainted(false);
                menuBack.addActionListener(handler);


                //SHOP BUTTONS


                JButton item1 = new JButton();
                this.item1=item1;
                item1.setIcon(foodIcon);
                item1.setBackground(ColorUIResource.WHITE);
                item1.setVerticalTextPosition(JLabel.CENTER);
                item1.addActionListener(handler);
                item1.setText("Food: 5g");
                item1.setToolTipText("10+ food");
                item1.setFocusPainted(false);

                JButton item2 = new JButton();
                this.item2 = item2;
                item2.setBackground(ColorUIResource.WHITE);
                item2.setIcon(energyDrinkIcon);
                item2.setVerticalTextPosition(JLabel.CENTER);
                item2.addActionListener(handler);
                item2.setText("Drink: 15g");
                item2.setToolTipText("10+ energy");
                item2.setFocusPainted(false);

                JButton item3 = new JButton();
                this.item3 = item3;
                item3.setIcon(lollipop);
                item3.addActionListener(handler);
                item3.setBackground(ColorUIResource.WHITE);
                item3.setText("Lollipop: 25g");
                item3.setToolTipText("5+ happiness");
                item3.setFocusPainted(false);

                JButton item4 = new JButton();
                this.item4 = item4;
                item4.setBackground(ColorUIResource.WHITE);
                item4.setIcon(shopBow);
                item4.setVerticalTextPosition(JLabel.CENTER);
                item4.addActionListener(handler);
                item4.setText("Bow: 500g");
                item4.setToolTipText("adds a pretty lil' bow");
                item4.setFocusPainted(false);

                JButton item5 = new JButton();
                this.item5 = item5;
                item5.setIcon(topHatIcon);
                item5.setText("Top hat: 800g");
                item5.setToolTipText("adds a classy top hat");
                item5.setBackground(ColorUIResource.WHITE);
                item5.setFocusPainted(false);
                item5.addActionListener(handler);

                JButton item6 = new JButton();
                this.item6 = item6;
                item6.setIcon(scarfIcon);
                item6.setText("Scarf: 1200g");
                item6.setToolTipText("adds a warm & comfy scarf");
                item6.addActionListener(handler);
                item6.setBackground(ColorUIResource.WHITE);
                item6.setFocusPainted(false);

                //LABELS

                JLabel infoLabel = new JLabel();
                infoLabel.setLayout(new GridLayout(1,2));
                infoLabel.setBorder(new EmptyBorder(10,0,0,0));
                infoLabel.add(menuBack);
                infoLabel.add(aboutInfo);
                infoLabel.setVisible(true);


                JLabel gold = new JLabel();
                this.gold=gold;
                gold.setBorder(new EmptyBorder(20,0,20,0));
                gold.setSize(50,50);
                gold.setBackground(ColorUIResource.WHITE);
                gold.setText(currentGnoxi.getGold()+"g");
                gold.setVerticalTextPosition(JLabel.CENTER);
                gold.setFont(new Font("Consolas", Font.BOLD, 20));
                gold.setIcon(goldIcon);


                JLabel gnoxi1 = new JLabel();                            //gnoxi label
                gnoxi1.setIcon(gnoxiIcon);
                gnoxi1.setText(currentGnoxi.getName()); //nameQuery
                gnoxi1.setVerticalTextPosition(JLabel.TOP);
                gnoxi1.setHorizontalTextPosition(JLabel.CENTER);
                gnoxi1.setForeground(Color.BLACK);


                JLabel hungerStat = new JLabel();                       //STATUS LABELS
                hungerStat.setText("Hunger");
                hungerStat.setFont(new Font("Consolas", Font.BOLD, 12));
                hungerStat.setForeground(Color.BLACK);


                JLabel happinessStat = new JLabel();
                happinessStat.setText("Happiness");
                happinessStat.setFont(new Font("Consolas", Font.BOLD, 12));
                happinessStat.setForeground(Color.BLACK);


                JLabel energyStat = new JLabel();
                energyStat.setText("Energy");
                energyStat.setFont(new Font("Consolas", Font.BOLD, 12));
                energyStat.setForeground(Color.BLACK);


                //PANELS

                JPanel shopPanel = new JPanel();
                this.shopPanel=shopPanel;
                shopPanel.setBackground(ColorUIResource.WHITE);//Shop panel
                shopPanel.setLayout(new GridLayout(7,1));
                shopPanel.add(item1);
                shopPanel.add(item2);
                shopPanel.add(item3);
                shopPanel.add(item4);
                shopPanel.add(item5);
                shopPanel.add(item6);
                shopPanel.add(infoLabel);




                JPanel StatusField = new JPanel();                          //Status field panel
                StatusField.setOpaque(false);
                StatusField.setLayout(new GridBagLayout());
                GridBagConstraints a = new GridBagConstraints();
                a.insets = new Insets(0,35,0,35);
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
                this.progressBar=progressBar;
                progressBar.setBorder(BorderFactory.createLineBorder(Color.black, 2));
                progressBar.setOpaque(false);
                progressBar.setMaximum(100);
                progressBar.setOrientation(JProgressBar.VERTICAL);
                progressBar.setPreferredSize(new Dimension(40, 40));

                JLabel happinessLabel = new JLabel();
                happinessLabel.setIcon(happinessIcon);
                happinessLabel.setOpaque(false);
                JLabel borderLabel = new JLabel();
                borderLabel.setIcon(borderTest);
                happinessLabel.setOpaque(false);
                JProgressBar progressBar2 = new JProgressBar();
                this.progressBar2=progressBar2;
                progressBar2.setBorder(BorderFactory.createLineBorder(Color.black, 2));
                progressBar2.setOpaque(false);
                progressBar2.setOrientation(JProgressBar.VERTICAL);
                progressBar2.setPreferredSize(new Dimension(40, 40));

                JLabel energyLabel = new JLabel();
                energyLabel.setIcon(energyIcon);
                energyLabel.setOpaque(false);
                JProgressBar progressBar3 = new JProgressBar();
                this.progressBar3=progressBar3;
                progressBar3.setBorder(BorderFactory.createLineBorder(Color.black, 2));
                progressBar3.setOpaque(false);
                progressBar3.setOrientation(JProgressBar.VERTICAL);
                progressBar3.setPreferredSize(new Dimension(40, 40));


                Container container = StatusField;
                a.gridx = 0;
                a.gridy = 1;
                container.add(hungerLabel,a);
                container.add(progressBar,a);
                a.gridx = 1;
                a.gridy = 1;
                container.add(happinessLabel,a);
                container.add(progressBar2,a);
                container.add(borderLabel,a);
                a.gridx = 2;
                a.gridy = 1;
                container.add(energyLabel,a);
                container.add(progressBar3,a);

                Thread incrementThread = new Thread(() -> {
                        while (currentGnoxi.getHunger()>0) {
                                currentGnoxi.setHunger(currentGnoxi.getHunger()-1);

                                progressBar.setValue(currentGnoxi.getHunger());
                                if(currentGnoxi.getHunger()==0){
                                        death();
                                }
                                if (currentGnoxi.getHunger() < 30) {
                                        progressBar.setForeground(Color.RED);
                                } if (currentGnoxi.getHunger() > 30 && currentGnoxi.getHunger() < 60){
                                        progressBar.setForeground(Color.yellow);
                                }
                                if(currentGnoxi.getHunger()>60){
                                        progressBar.setForeground(Color.green);
                                }

                                try {
                                        Thread.sleep(2000); // Pause the thread
                                } catch (InterruptedException e) {
                                        // If the thread is interrupted, break out of the loop
                                        break;
                                }
                        }
                });

                incrementThread.start();
                Thread incrementThread2 = new Thread(() -> {
                        while (currentGnoxi.getHappiness()>0) {
                                currentGnoxi.setHappiness(currentGnoxi.getHappiness()-1);

                                progressBar2.setValue(currentGnoxi.getHappiness());
                                if(currentGnoxi.getHappiness()==0){
                                        death();
                                }
                                if (currentGnoxi.getHappiness() < 30) {
                                        progressBar2.setForeground(Color.RED);
                                } if (currentGnoxi.getHappiness() > 30 && currentGnoxi.getHappiness() < 60){
                                        progressBar2.setForeground(Color.yellow);
                                }
                                if(currentGnoxi.getHappiness()>60){
                                        progressBar2.setForeground(Color.green);
                                }

                                try {
                                        Thread.sleep(2000); // Pause the thread
                                } catch (InterruptedException e) {
                                        // If the thread is interrupted, break out of the loop
                                        break;
                                }
                        }
                });
                incrementThread2.start();

                Thread incrementThread3 = new Thread(() -> {
                        while (currentGnoxi.getEnergy()>0) {
                                if(!currentGnoxi.getSleeping()){
                                currentGnoxi.setEnergy(currentGnoxi.getEnergy()-1);}
                                if(currentGnoxi.getSleeping()&&currentGnoxi.getEnergy()<100){
                                        currentGnoxi.setEnergy(currentGnoxi.getEnergy()+2);}
                                if(currentGnoxi.getEnergy()==0){
                                        death();
                                }
                                progressBar3.setValue(currentGnoxi.getEnergy());
                                if (currentGnoxi.getEnergy() < 30) {
                                        progressBar3.setForeground(Color.RED);
                                } if (currentGnoxi.getEnergy() > 30 && currentGnoxi.getEnergy() < 60){
                                        progressBar3.setForeground(Color.yellow);
                                }
                                if(currentGnoxi.getEnergy()>60){
                                        progressBar3.setForeground(Color.green);
                                }
                                try {
                                        Thread.sleep(2000); // Pause the thread
                                } catch (InterruptedException e) {
                                        // If the thread is interrupted, break out of the loop
                                        break;
                                }
                        }
                });
                incrementThread3.start();
                JButton randPoop = new JButton();
                this.randPoop = randPoop;
                randPoop.setIcon(poopIcon);
                randPoop.setBorderPainted(false);
                randPoop.setBackground(ColorUIResource.PINK);
                randPoop.setFocusPainted(false);
                randPoop.setContentAreaFilled(false);
                randPoop.setLayout(null);
                randPoop.setOpaque(false);
                randPoop.repaint();
                randPoop.addActionListener(handler);



                JLabel bowLabel = new JLabel();
                this.bowLabel = bowLabel;
                bowLabel.setIcon(new ImageIcon("Media/Gnoxi/gnoxiBow.png"));
                bowLabel.setVisible(currentGnoxi.isBow());
                if(bowLabel.isVisible()){
                        item4.setIcon(shopBow2);
                        item4.repaint();
                }

                JLabel scarfLabel = new JLabel();
                this.scarfLabel = scarfLabel;
                scarfLabel.setVisible(false);
                scarfLabel.setIcon(gnoxiScarf);
                scarfLabel.setVisible(currentGnoxi.isScarf());
                if(scarfLabel.isVisible()){
                        item6.setIcon(scarfIcon2);
                        item6.repaint();
                }

                JLabel tophatLabel = new JLabel();
                this.tophatLabel = tophatLabel;
                tophatLabel.setVisible(false);
                tophatLabel.setIcon(gnoxiTophat);
                tophatLabel.setVisible(currentGnoxi.isTophat());
                if(tophatLabel.isVisible()){
                        item5.setIcon(topHatIcon2);
                        item5.repaint();
                }

                JLabel sleepLabel = new JLabel();
                this.sleepLabel = sleepLabel;
                sleepLabel.setIcon(gnoxiSleep);
                sleepLabel.setVisible(false);


                JPanel gnoxi = new JPanel();
                this.gnoxi=gnoxi;
                //Gnoxi panel
                gnoxi.setLayout(new GridBagLayout());
                GridBagConstraints q = new GridBagConstraints();
                gnoxi.setOpaque(false);
                q.gridx = 0;
                q.gridy = 0;
                JLabel gnoxiDie = new JLabel();
                this.gnoxiDie=gnoxiDie;
                gnoxiDie.setIcon(gnoxiDead);
                gnoxi.add(gnoxiDie);
                gnoxiDie.setVisible(false);
                gnoxi.add(bowLabel,q);
                gnoxi.add(tophatLabel,q);
                gnoxi.add(scarfLabel,q);
                gnoxi.add(sleepLabel,q);
                gnoxi.add(gnoxi1,q);
                gnoxi.setBorder(new EmptyBorder(20,0,0,0));
                randPoop.setBorder(new EmptyBorder(0, 260, 0, 0));
                gnoxi.add(randPoop, q);
                randPoop.setVisible(false);

                Thread incrementThread4 = new Thread(() -> {
                        Random randomX = new Random();
                        int xMax = 1200000;
                        int int_randomX = randomX.nextInt(xMax);
                        while (currentGnoxi.getHunger()>0) {
                                if(currentGnoxi.getHunger()>60&&!currentGnoxi.getSleeping()) {
                                        randPoop.setBorder(new EmptyBorder(0, 255, 0, 0));
                                        randPoop.setVisible(true);
                                }
                                try {
                                        Thread.sleep(int_randomX); // Pause the thread
                                } catch (InterruptedException e) {
                                        // If the thread is interrupted, break out of the loop
                                        break;
                                }
                        }
                });

                incrementThread4.start();
                Thread incrementThread5 = new Thread(() -> {
                        while (currentGnoxi.getHunger()>0) {
                                if(currentGnoxi.getHappiness()>60){
                                        currentGnoxi.setGold(currentGnoxi.getGold()+1);
                                }
                                if(currentGnoxi.getHappiness()>80){
                                        currentGnoxi.setGold(currentGnoxi.getGold()+1);
                                }
                                gold.setText(currentGnoxi.getGold()+"g");
                                try {
                                        Thread.sleep(6000); // Pause the thread
                                } catch (InterruptedException e) {
                                        // If the thread is interrupted, break out of the loop
                                        break;
                                }
                        }
                });
                incrementThread5.start();
                Thread incrementThread6 = new Thread(() -> {
                        while (currentGnoxi.getHunger()>0&&currentGnoxi.getHappiness()<100) {
                                if(currentGnoxi.getHunger()>60&&currentGnoxi.getEnergy()>60) {
                                        currentGnoxi.setHappiness(currentGnoxi.getHappiness()+3);
                                }
                                if(currentGnoxi.getHunger()<60){
                                        currentGnoxi.setHappiness(currentGnoxi.getHappiness()-2);
                                }
                                if(currentGnoxi.getEnergy()<60){
                                        currentGnoxi.setHappiness(currentGnoxi.getHappiness()-2);
                                }
                                if(currentGnoxi.getHappiness()<1){
                                        death();
                                }
                                try {
                                        Thread.sleep(2000); // Pause the thread
                                } catch (InterruptedException e) {
                                        // If the thread is interrupted, break out of the loop
                                        break;
                                }
                        }
                });
                incrementThread6.start();


                JPanel Interaction = new JPanel();                          //Interaction panel
                Interaction.setOpaque(false);
                Interaction.setBorder(new EmptyBorder(5,0,0,200));
                sleep.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(Color.BLACK, 2),
                        BorderFactory.createEmptyBorder(4, 15, 4, 15)));

                Interaction.add(sleep);
                Interaction.setLayout(new FlowLayout(FlowLayout.LEFT,70,0));


                JPanel GnoxiPanel = new JPanel();
                this.GnoxiPanel=GnoxiPanel;
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
                d.fill = GridBagConstraints.BOTH;
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
                frame.add(shopPanel,c);
                c.gridy = 0;
                d.ipady=0;
                c.gridx = 3;
                c.fill = GridBagConstraints.CENTER;
                frame.add(gold,c);
                Container j = frame.getContentPane();

                j.setBackground(ColorUIResource.WHITE);

                if(currentGnoxi.getSleeping()){
                        sleepLabel.setVisible(true);
                        shopPanel.setVisible(false);
                        gold.setVisible(false);
                        GnoxiPanel.setBackground(new Color(52,51,97));
                }
        }
        private class ButtonHandler implements ActionListener {
                public void actionPerformed(ActionEvent e) {

                        if (e.getSource()==sleep){
                                if (currentGnoxi.getSleeping()){

                                        if(Menu.onOff==1) {
                                                Menu.musicPlayer("Cascade");
                                        }
                                        frame.setSize(700,500);
                                        currentGnoxi.setSleeping(false);
                                        sleepLabel.setVisible(false);
                                        shopPanel.setVisible(true);
                                        gold.setVisible(true);
                                        GnoxiPanel.setBackground(ColorUIResource.PINK);
                                }
                                else {

                                        if(Menu.onOff==1) {
                                                Menu.musicPlayer("It's okay");
                                        }
                                        frame.setSize(500,500);
                                        currentGnoxi.setSleeping(true);
                                        sleepLabel.setVisible(true);
                                        shopPanel.setVisible(false);
                                        gold.setVisible(false);
                                        GnoxiPanel.setBackground(new Color(52,51,97));
                                }
                        }

                        if (e.getSource() == randPoop){
                                currentGnoxi.setGold(currentGnoxi.gold +=10);
                                randPoop.setVisible(false);
                        }

                        if(e.getSource()==aboutInfo){
                                death();
                        }
                        if(e.getSource()==menuBack){
                                frame.dispose();
                                Gnoxi.save();
                                Menu.musicPlayer("Limerence");
                                new Menu ();
                        }

                        if (e.getSource() == item1) {

                                if(!shop.buy(1)){
                                        JOptionPane.showMessageDialog(item1,"You dont have enough gold","Shop", JOptionPane.ERROR_MESSAGE);
                                }
                                else if (currentGnoxi.getHunger() == 100) {
                                        return;
                                }
                                else if (currentGnoxi.getHunger() + 10 > 100) {
                                        currentGnoxi.setHunger(100);
                                        progressBar.setValue(currentGnoxi.getHunger());
                                }
                                else {
                                        currentGnoxi.setHunger(currentGnoxi.getHunger() + 10);
                                        progressBar.setValue(currentGnoxi.getHunger());
                                        System.out.println(item1.getSize());
                                }

                        }
                        if (e.getSource() == item2) {

                                if(!shop.buy(2)){
                                        JOptionPane.showMessageDialog(item2,"You dont have enough gold","Shop", JOptionPane.ERROR_MESSAGE);
                                }
                                else if (currentGnoxi.getEnergy() == 100){
                                        return;
                                }
                                else if (currentGnoxi.getEnergy()+10 > 100){
                                        currentGnoxi.setEnergy(100);
                                        progressBar3.setValue(currentGnoxi.getEnergy());

                                }
                                else {
                                        currentGnoxi.setEnergy(currentGnoxi.getEnergy()+10);
                                        progressBar3.setValue(currentGnoxi.getEnergy());
                                }

                        }
                        if (e.getSource() == item3) {
                                if(!shop.buy(3)){
                                        JOptionPane.showMessageDialog(item3,"You dont have enough gold","Shop", JOptionPane.ERROR_MESSAGE);
                                }
                                else if (currentGnoxi.getHappiness() == 100){
                                        return;
                                }
                                else if (currentGnoxi.getHappiness()+5 > 100){
                                        currentGnoxi.setHappiness(100);
                                        progressBar2.setValue(currentGnoxi.getHappiness());

                                }
                                else {
                                        currentGnoxi.setHappiness(currentGnoxi.getHappiness()+5);
                                        progressBar2.setValue(currentGnoxi.getHappiness());
                                }
                        }

                        if (e.getSource() == item4) {
                                if (bowLabel.isVisible()) {
                                        JOptionPane.showMessageDialog(item4, "Already owned", "Shop", JOptionPane.ERROR_MESSAGE);
                                        return;
                                }

                                else {
                                        if(!shop.buy(4)){
                                                JOptionPane.showMessageDialog(item4,"You dont have enough gold","Shop", JOptionPane.ERROR_MESSAGE);
                                        }
                                        else {
                                                shop.buy(4);
                                                item4.setOpaque(false);
                                                item4.setIcon(shopBow2);
                                                item4.repaint();
                                                bowLabel.setVisible(true);
                                                currentGnoxi.setBow(true);
                                        }
                                }
                        }
                        if (e.getSource() == item5) {
                                if (tophatLabel.isVisible()) {
                                        JOptionPane.showMessageDialog(item5, "Already owned", "Shop", JOptionPane.ERROR_MESSAGE);
                                        return;
                                }

                                else {
                                        if(!shop.buy(5)){
                                                JOptionPane.showMessageDialog(item5,"You dont have enough gold","Shop", JOptionPane.ERROR_MESSAGE);
                                        }
                                        else {
                                                shop.buy(5);
                                                item5.setOpaque(false);
                                                item5.setIcon(topHatIcon2);
                                                item5.repaint();
                                                tophatLabel.setVisible(true);
                                                currentGnoxi.setTophat(true);
                                        }
                                }
                        }
                        if (e.getSource() == item6) {
                                if (scarfLabel.isVisible()) {
                                        JOptionPane.showMessageDialog(item6, "Already owned", "Shop", JOptionPane.ERROR_MESSAGE);
                                        return;
                                }

                                else {
                                        if(!shop.buy(6)){
                                                JOptionPane.showMessageDialog(item6,"You dont have enough gold","Shop", JOptionPane.ERROR_MESSAGE);
                                        }
                                        else {
                                                shop.buy(5);
                                                item6.setOpaque(false);
                                                item6.setIcon(scarfIcon2);
                                                item6.repaint();
                                                scarfLabel.setVisible(true);
                                                currentGnoxi.setScarf(true);
                                        }
                                }
                        }
                        gold.setText(currentGnoxi.getGold()+"g");
                }
        }
}