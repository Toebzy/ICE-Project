import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
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
        private JPanel StatusField;
        public Shop shop = new Shop();
        private boolean Death = false;   //stops multiple deaths
        private boolean hasPooped = false;
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
        private JLabel background;
        private boolean menuPause = false;
        private ImageIcon shopBow2;
        private ImageIcon scarfIcon2;
        private ImageIcon topHatIcon2;
        private ImageIcon hoverTopHat;
        private ImageIcon bowHover;
        private ImageIcon scarfHover;
        private ImageIcon backgroundIcon;
        private ImageIcon backgroundIcon2;
        private JFrame frame;


        public static void newGnoxi(){            //asks user to input name
                String nameQuery = JOptionPane.showInputDialog(null,"Enter the name of your Gnoxi", "Gnoxi Creation", JOptionPane.QUESTION_MESSAGE);
                if(nameQuery == null || (nameQuery != null && ("".equals(nameQuery))))
                {
                        new Menu();
                }
                else {
                        Gnoxi currentGnoxi = new Gnoxi(nameQuery, 0, 100, 100, 100, System.currentTimeMillis(), 0, false, Gnoxi.gnoxiType(), false, false, false);      //creates new gnoxi
                        FileIO.writeGnoxi(currentGnoxi);  //saves gnoxi to CSV
                        new GUI(currentGnoxi);            //starts GUI
                }
        }
        public static void oldGnoxi(){     //sets currentGnoxi to csv data
                currentGnoxi=FileIO.createOldGnoxi();
                new GUI(currentGnoxi);
        }
        public void death(){
                Death = true;
                Gnoxi.save(); //saves current Gnoxi to print final age
                gnoxiDie.setVisible(true);
                int result = JOptionPane.showConfirmDialog(item3, "Your Gnoxi has died, it was alive for " +
                                Calculator.calcAge(currentGnoxi.getAge())+
                                " days \n                 Start new game?", "Death",
                                JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                  FileIO.deleteSave();  //deletes current save, to avoid getting around dying :)
                if(result == JOptionPane.YES_OPTION){
                        newGnoxi();
                        frame.dispose();
                }
                if (result == JOptionPane.NO_OPTION || result == JOptionPane.CLOSED_OPTION){
                        new Menu(); //goes back to menu
                        frame.dispose();
                }
                FileIO.deleteSave();
        }
        public GUI(Gnoxi currentGnoxi) {
                this.currentGnoxi = currentGnoxi;

                if (Menu.onOff == 1) {    //plays music if it's turned ON
                        Menu.musicPlayer("It's Okay");
                }

                //ICONS

                ImageIcon backgroundIcon = new ImageIcon("Media/Menu/gnoxiBackground.png");        //background
                ImageIcon backgroundIcon2 = new ImageIcon("Media/Menu/gnoxiBackground2.png");      //background
                ImageIcon happinessIcon = new ImageIcon("Media/StatusBars/happiness.png");         //happiness
                ImageIcon hungerIcon = new ImageIcon("Media/StatusBars/hunger.png");               //hunger
                ImageIcon energyIcon = new ImageIcon("Media/StatusBars/energy.png");               //energy
                ImageIcon logoIcon = new ImageIcon("Media/Menu/gnoxiIcon.png");                    //logo
                ImageIcon gnoxiIcon = new ImageIcon("Media/Gnoxi/" + currentGnoxi.gnoxiType + ".png"); //Gnoxi
                ImageIcon gnoxiTophat = new ImageIcon("Media/Gnoxi/gnoxiTophat.png");              //Gnoxi top hat
                ImageIcon gnoxiScarf = new ImageIcon("Media/Gnoxi/gnoxiScarf.png");                //Gnoxi scarf
                ImageIcon sleepIcon = new ImageIcon("Media/Interaction/sleepIcon.png");            //sleep
                ImageIcon aboutIcon = new ImageIcon("Media/Interaction/aboutIcon.png");             //aboutInfo
                ImageIcon backIcon = new ImageIcon("Media/Interaction/backIcon.png");              //back to menu
                ImageIcon gnoxiSleep = new ImageIcon("Media/Gnoxi/gnoxiSleep.png");                 //sleepThingg
                ImageIcon poopIcon = new ImageIcon("Media/Gnoxi/gnoxiPoop.png");                   //poop
                ImageIcon foodIcon = new ImageIcon("Media/ShopIcons/foodIcon.png");                //food
                ImageIcon foodHover = new ImageIcon("Media/ShopIcons/foodHover.png");              //food hover
                ImageIcon energyDrinkIcon = new ImageIcon("Media/ShopIcons/energyDrinkIcon.png");  //coffee
                ImageIcon coffeeHover = new ImageIcon("Media/ShopIcons/coffeeHover.png");          //coffee hover
                ImageIcon shopBow = new ImageIcon("Media/ShopIcons/shopBow.png");                  //shop bow
                ImageIcon bowHover = new ImageIcon("Media/ShopIcons/bowHover.png");                //shop bow hover
                ImageIcon shopBow2 = new ImageIcon("Media/ShopIcons/shopBow2.png");                //shop bow bought
                ImageIcon gnoxiDead = new ImageIcon("Media/Gnoxi/gnoxiDead.png");                   //dead
                ImageIcon lollipop = new ImageIcon("Media/ShopIcons/lollipop.png");                 //lollipop
                ImageIcon lollipopHover = new ImageIcon("Media/ShopIcons/lollipopHover.png");       //lollipop hover
                ImageIcon topHatIcon = new ImageIcon("Media/ShopIcons/topHatIcon.png");             //topHat
                ImageIcon hoverTopHat = new ImageIcon("Media/ShopIcons/hoverTopHat.png");            //topHat hover
                ImageIcon topHatIcon2 = new ImageIcon("Media/ShopIcons/topHatIcon2.png");           //topHat bought
                ImageIcon scarfIcon = new ImageIcon("Media/ShopIcons/scarfIcon.png");               //scarf
                ImageIcon scarfHover = new ImageIcon("Media/ShopIcons/scarfHover.png");             //scarf hover
                ImageIcon scarfIcon2 = new ImageIcon("Media/ShopIcons/scarfIcon2.png");             //scarf bought

                this.backgroundIcon = backgroundIcon;
                this.backgroundIcon2 = backgroundIcon2;
                this.scarfIcon2 = scarfIcon2;
                this.topHatIcon2 = topHatIcon2;
                this.hoverTopHat = hoverTopHat;
                this.bowHover = bowHover;
                this.scarfHover = hoverTopHat;
                this.shopBow2 = shopBow2;

                //Button handler for all the buttons
                ButtonHandler handler = new ButtonHandler();

                //BUTTONS

                JButton sleep = new JButton();
                sleep.setOpaque(false);
                this.sleep = sleep;
                sleep.setIcon(sleepIcon);       //sleep button and icon
                sleep.setFocusPainted(false);
                sleep.setOpaque(false);
                sleep.setContentAreaFilled(false);
                sleep.addActionListener(handler);

                aboutInfo = new JButton();
                aboutInfo.setOpaque(false);     //info button
                aboutInfo.setIcon(aboutIcon);
                aboutInfo.setFocusPainted(false);
                aboutInfo.setBorderPainted(false);
                aboutInfo.addActionListener(handler);
                aboutInfo.setOpaque(false);
                aboutInfo.setContentAreaFilled(false);

                menuBack = new JButton();
                menuBack.setIcon(backIcon);     //back to menu button
                menuBack.setOpaque(false);
                menuBack.setFocusPainted(false);
                menuBack.setBorderPainted(false);
                menuBack.addActionListener(handler);
                menuBack.setOpaque(false);
                menuBack.setContentAreaFilled(false);

                //SHOP BUTTONS

                JButton item1 = new JButton();
                this.item1 = item1;
                item1.setIcon(foodIcon);
                item1.setContentAreaFilled(false);
                item1.setBorder(new EmptyBorder(0, 0, 18, 0));
                item1.setRolloverIcon(foodHover);
                item1.addActionListener(handler);
                item1.setToolTipText("10+ food");
                item1.setFocusPainted(false);

                JButton item2 = new JButton();
                this.item2 = item2;
                item2.setIcon(energyDrinkIcon);
                item2.setContentAreaFilled(false);
                item2.setBorder(new EmptyBorder(0, 0, 18, 0));
                item2.setRolloverIcon(coffeeHover);
                item2.addActionListener(handler);
                item2.setToolTipText("10+ energy");                     //shop item 2 (coffee)
                item2.setFocusPainted(false);

                JButton item3 = new JButton();
                this.item3 = item3;
                item3.setIcon(lollipop);
                item3.setContentAreaFilled(false);
                item3.setBorder(new EmptyBorder(0, 0, 18, 0)); //shop item 3 (lollipop)
                item3.setRolloverIcon(lollipopHover);
                item3.addActionListener(handler);
                item3.setToolTipText("5+ happiness");
                item3.setFocusPainted(false);

                JButton item4 = new JButton();
                this.item4 = item4;                                     //shop item 4 (bow)
                item4.setIcon(shopBow);
                item4.setContentAreaFilled(false);
                item4.setBorder(new EmptyBorder(0, 0, 18, 0));
                item4.setRolloverIcon(bowHover);
                item4.addActionListener(handler);
                item4.setToolTipText("Adds a pretty lil' bow, and a poop buff");
                item4.setFocusPainted(false);

                JButton item5 = new JButton();
                this.item5 = item5;                                     //shop item 5 (tophat)
                item5.setIcon(topHatIcon);
                item5.setContentAreaFilled(false);
                item5.setBorder(new EmptyBorder(0, 0, 18, 0));
                item5.setRolloverIcon(hoverTopHat);
                item5.setToolTipText("Adds a classy top hat, also earn more gold");
                item5.setFocusPainted(false);
                item5.addActionListener(handler);

                JButton item6 = new JButton();
                this.item6 = item6;                                     //shop item 6 (scarf)
                item6.setIcon(scarfIcon);
                item6.setContentAreaFilled(false);
                item6.setBorder(new EmptyBorder(0, 0, 18, 0));
                item6.setRolloverIcon(scarfHover);
                item6.setToolTipText("Adds comfy scarf, and happiness decreases slower ");
                item6.addActionListener(handler);
                item6.setFocusPainted(false);

                //LABELS

                JLabel infoLabel = new JLabel();
                infoLabel.setLayout(new GridLayout(1, 2));
                infoLabel.setBorder(new EmptyBorder(0, 0, 18, 0));
                infoLabel.add(menuBack);
                infoLabel.add(aboutInfo);                               //label for info and menuBack
                infoLabel.setVisible(true);

                JLabel gold = new JLabel();
                this.gold = gold;
                gold.setBorder(new EmptyBorder(28, 42, 32, 0));
                gold.setSize(50, 50);
                gold.setText(currentGnoxi.getGold() + "");
                gold.setVerticalTextPosition(JLabel.CENTER);
                gold.setFont(new Font("Arial", Font.BOLD, 14));

                JLabel gnoxi1 = new JLabel();                            //gnoxi label
                gnoxi1.setIcon(gnoxiIcon);
                gnoxi1.setText(currentGnoxi.getName()); //nameQuery
                gnoxi1.setVerticalTextPosition(JLabel.TOP);
                gnoxi1.setHorizontalTextPosition(JLabel.CENTER);
                gnoxi1.setFont(new Font ("Arial", Font.BOLD, 20));
                gnoxi1.setForeground(Color.BLACK);


                //PANELS

                JPanel shopPanel = new JPanel();
                this.shopPanel = shopPanel;
                shopPanel.setOpaque(false);
                shopPanel.setBorder(new EmptyBorder(11, 0, 0, 5));
                shopPanel.setLayout(new GridLayout(7, 1));
                shopPanel.add(item1);
                shopPanel.add(item2);
                shopPanel.add(item3);                   //shop panel for all items
                shopPanel.add(item4);
                shopPanel.add(item5);
                shopPanel.add(item6);
                shopPanel.add(infoLabel);


                JPanel StatusField = new JPanel();                       //Status field panel
                this.StatusField=StatusField;
                StatusField.setOpaque(false);
                StatusField.setLayout(new GridBagLayout());
                StatusField.setBorder(new EmptyBorder(13, 78, 0, 0));
                GridBagConstraints a = new GridBagConstraints();
                a.insets = new Insets(0, 0, 0, 91);
                a.anchor = GridBagConstraints.CENTER;
                a.gridx = 0;
                a.gridy = 0;

                JLabel hungerLabel = new JLabel();
                hungerLabel.setIcon(hungerIcon);
                hungerLabel.setOpaque(false);

                JProgressBar progressBar = new JProgressBar();          //progressbar for hunger
                this.progressBar = progressBar;
                progressBar.setOpaque(false);
                progressBar.setBorderPainted(false);
                progressBar.setMaximum(100);
                progressBar.setOrientation(JProgressBar.VERTICAL);
                progressBar.setPreferredSize(new Dimension(40, 40));

                JLabel happinessLabel = new JLabel();
                happinessLabel.setIcon(happinessIcon);
                happinessLabel.setOpaque(false);
                JLabel borderLabel = new JLabel();
                happinessLabel.setOpaque(false);

                JProgressBar progressBar2 = new JProgressBar();         //progressbar for happiness
                this.progressBar2 = progressBar2;
                progressBar2.setMaximum(100);
                progressBar2.setOpaque(false);
                progressBar2.setBorderPainted(false);
                progressBar2.setOrientation(JProgressBar.VERTICAL);
                progressBar2.setPreferredSize(new Dimension(40, 40));

                JLabel energyLabel = new JLabel();
                energyLabel.setIcon(energyIcon);
                energyLabel.setOpaque(false);

                JProgressBar progressBar3 = new JProgressBar();
                this.progressBar3 = progressBar3;
                progressBar3.setMaximum(100);

                progressBar3.setOpaque(false);                          //progressbar for energy
                progressBar3.setBorderPainted(false);
                progressBar3.setOrientation(JProgressBar.VERTICAL);
                progressBar3.setPreferredSize(new Dimension(40, 40));


                Container container = StatusField;
                a.gridx = 0;
                a.gridy = 1;
                container.add(hungerLabel, a);
                container.add(progressBar, a);
                a.gridx = 1;
                a.gridy = 1;
                container.add(happinessLabel, a);
                container.add(progressBar2, a);
                container.add(borderLabel, a);
                a.gridx = 2;
                a.gridy = 1;
                container.add(energyLabel, a);
                container.add(progressBar3, a);

                Thread incrementThread = new Thread(() -> {                     //thread to lower hunger progressbar
                        while (!menuPause && currentGnoxi.getHunger() > 0) {
                                hungerLabel.setToolTipText(currentGnoxi.getHunger() + "" + "%");
                                currentGnoxi.setHunger(currentGnoxi.getHunger() - 1);

                                progressBar.setValue(currentGnoxi.getHunger());
                                if (currentGnoxi.getHunger() == 0 && !Death) {
                                        death();        //gnoxi dies if it hits 0 (if not dead already)
                                }
                                if (currentGnoxi.getHunger() < 30) {
                                        progressBar.setForeground(new Color(240, 79, 63));
                                }
                                if (currentGnoxi.getHunger() > 30 && currentGnoxi.getHunger() < 60) {
                                        progressBar.setForeground(new Color(71, 137, 210));
                                }
                                if (currentGnoxi.getHunger() > 60) {
                                        progressBar.setForeground(new Color(119, 176, 43));
                                }

                                try {
                                        Thread.sleep(3000); // Pause the thread
                                } catch (InterruptedException e) {
                                        // If the thread is interrupted, break out of the loop
                                        System.out.println(e);
                                        break;
                                }
                        }
                });

                incrementThread.start();
                Thread incrementThread2 = new Thread(() -> {                     //thread to lower happiness progressbar
                        while (!menuPause && currentGnoxi.getHappiness() > 0) {
                                happinessLabel.setToolTipText(currentGnoxi.getHappiness() + "" + "%");

                                progressBar2.setValue(currentGnoxi.getHappiness());
                                if (currentGnoxi.getHappiness() <= 0 && !Death) {
                                        death();        //gnoxi dies if it hits 0 (if not dead already)
                                }
                                if (currentGnoxi.getHappiness() < 30) {
                                        progressBar2.setForeground(new Color(240, 79, 63));
                                }
                                if (currentGnoxi.getHappiness() > 30 && currentGnoxi.getHappiness() < 60) {
                                        progressBar2.setForeground(new Color(71, 137, 210));
                                }
                                if (currentGnoxi.getHappiness() > 60) {
                                        progressBar2.setForeground(new Color(119, 176, 43));
                                }

                                try {
                                        Thread.sleep(2000); // Pause the thread
                                } catch (InterruptedException e) {
                                        // If the thread is interrupted, break out of the loop
                                        System.out.println(e);
                                        break;
                                }
                        }
                });
                incrementThread2.start();

                Thread incrementThread3 = new Thread(() -> {                     //thread to lower energy progressbar
                        while (!menuPause && currentGnoxi.getEnergy() > 0) {
                                energyLabel.setToolTipText(currentGnoxi.getEnergy() + "" + "%");
                                if (!currentGnoxi.getSleeping()) {
                                        currentGnoxi.setEnergy(currentGnoxi.getEnergy() - 1);
                                }
                                if (currentGnoxi.getSleeping() && currentGnoxi.getEnergy() < 100) {
                                        currentGnoxi.setEnergy(currentGnoxi.getEnergy() + 1);
                                }
                                if (currentGnoxi.getEnergy() == 0 && !Death) {
                                        death();        //gnoxi dies if it hits 0 (if not dead already)
                                }
                                progressBar3.setValue(currentGnoxi.getEnergy());
                                if (currentGnoxi.getEnergy() < 30) {
                                        progressBar3.setForeground(new Color(240, 79, 63));
                                }
                                if (currentGnoxi.getEnergy() > 30 && currentGnoxi.getEnergy() < 60) {
                                        progressBar3.setForeground(new Color(71, 137, 210));
                                }
                                if (currentGnoxi.getEnergy() > 60) {
                                        progressBar3.setForeground(new Color(119, 176, 43));
                                }
                                try {
                                        Thread.sleep(2000); // Pause the thread
                                } catch (InterruptedException e) {
                                        // If the thread is interrupted, break out of the loop
                                        System.out.println(e);
                                        break;
                                }
                        }
                });
                incrementThread3.start();


                JButton randPoop = new JButton();
                this.randPoop = randPoop;
                randPoop.setIcon(poopIcon);
                randPoop.setBorderPainted(false);
                randPoop.setFocusPainted(false);
                randPoop.setContentAreaFilled(false);
                randPoop.setLayout(null);
                randPoop.setOpaque(false);
                randPoop.repaint();
                randPoop.addActionListener(handler);


                JLabel bowLabel = new JLabel();
                this.bowLabel = bowLabel;
                bowLabel.setIcon(new ImageIcon("Media/Gnoxi/gnoxiBow.png"));
                bowLabel.setVisible(false);
                bowLabel.setVisible(currentGnoxi.hasBow());
                if (bowLabel.isVisible()|| currentGnoxi.hasBow()) {
                        item4.setIcon(shopBow2);
                        item4.setRolloverIcon(shopBow2);
                        item4.repaint();
                }
                if (!bowLabel.isVisible() || !currentGnoxi.hasBow()) {
                        item4.setRolloverIcon(bowHover);
                        item4.repaint();
                }

                JLabel scarfLabel = new JLabel();
                this.scarfLabel = scarfLabel;
                scarfLabel.setBorder(new EmptyBorder(2, 0, 0, 0));
                scarfLabel.setVisible(false);
                scarfLabel.setIcon(gnoxiScarf);
                scarfLabel.setVisible(currentGnoxi.hasScarf());
                if (scarfLabel.isVisible()|| currentGnoxi.hasScarf()) {
                        item6.setIcon(scarfIcon2);
                        item6.setRolloverIcon(scarfIcon2);
                        item6.repaint();
                }
                if (!scarfLabel.isVisible() || !currentGnoxi.hasScarf()) {
                        item6.setRolloverIcon(scarfHover);
                        item6.repaint();
                }

                JLabel tophatLabel = new JLabel();
                this.tophatLabel = tophatLabel;
                tophatLabel.setVisible(false);
                tophatLabel.setIcon(gnoxiTophat);
                tophatLabel.setVisible(currentGnoxi.hasTophat());
                if (tophatLabel.isVisible()|| currentGnoxi.hasTophat()) {
                        item5.setIcon(topHatIcon2);
                        item5.setRolloverIcon(topHatIcon2);
                        item5.repaint();
                }
                if (!tophatLabel.isVisible() || !currentGnoxi.hasTophat()) {
                        item5.setRolloverIcon(hoverTopHat);
                        item5.repaint();
                }


                JLabel sleepLabel = new JLabel();
                this.sleepLabel = sleepLabel;
                sleepLabel.setIcon(gnoxiSleep);
                sleepLabel.setVisible(false);


                JPanel gnoxi = new JPanel();
                this.gnoxi = gnoxi;
                //Gnoxi panel
                gnoxi.setLayout(new GridBagLayout());
                GridBagConstraints q = new GridBagConstraints();
                gnoxi.setOpaque(false);
                q.gridx = 0;
                q.gridy = 0;
                JLabel gnoxiDie = new JLabel();
                this.gnoxiDie = gnoxiDie;
                gnoxiDie.setIcon(gnoxiDead);
                gnoxi.add(gnoxiDie);
                gnoxiDie.setVisible(false);
                gnoxi.add(bowLabel, q);
                gnoxi.add(tophatLabel, q);
                gnoxi.add(scarfLabel, q);
                gnoxi.add(sleepLabel, q);
                gnoxi.add(gnoxi1, q);
                gnoxi.setBorder(new EmptyBorder(20, 0, 0, 0));
                randPoop.setBorder(new EmptyBorder(0, 260, 0, 0));
                gnoxi.add(randPoop, q);
                randPoop.setVisible(false);

                Thread incrementThread4 = new Thread(() -> {    //spawns poop on random timer
                        Random randomX = new Random();
                        int xMax = 30000;  //lower number = more poops
                        while (!menuPause && currentGnoxi.getHunger() > 0) {
                                int int_randomX = randomX.nextInt(xMax);
                                if (currentGnoxi.getHunger() > 30 && !currentGnoxi.getSleeping()) {
                                        randPoop.setBorder(new EmptyBorder(0, 255, 0, 0));
                                        randPoop.setVisible(true);
                                        if (!currentGnoxi.getSleeping() && !hasPooped) {
                                                sfxPlayer("poopSound");
                                                hasPooped = true;
                                        }
                                }
                                try {
                                        Thread.sleep(int_randomX); // Pause the thread
                                } catch (InterruptedException e) {
                                        // If the thread is interrupted, break out of the loop
                                        System.out.println(e);
                                        break;
                                }
                        }
                });

                incrementThread4.start();  //gives gold while happiness is high

                Thread incrementThread5 = new Thread(() -> {
                        while (!menuPause && currentGnoxi.getHunger() > 0) {
                                if (currentGnoxi.getHappiness() > 60) {
                                        currentGnoxi.setGold(currentGnoxi.getGold() + 1);
                                }
                                if (currentGnoxi.getHappiness() > 80) {
                                        currentGnoxi.setGold(currentGnoxi.getGold() + 2);
                                }
                                if (currentGnoxi.getHappiness() > 90) {
                                        currentGnoxi.setGold(currentGnoxi.getGold() + 1);
                                }
                                if(currentGnoxi.getEnergy()>80&&currentGnoxi.getHunger()<80){
                                        currentGnoxi.setGold(currentGnoxi.getGold() + 2);
                                }
                                if (currentGnoxi.hasTophat()) {   //tophat gives passive gold
                                        currentGnoxi.setGold(currentGnoxi.getGold() + 2);
                                }
                                gold.setText(currentGnoxi.getGold() + "");
                                try {
                                        Thread.sleep(6000); // Pause the thread
                                } catch (InterruptedException e) {
                                        // If the thread is interrupted, break out of the loop
                                        System.out.println(e);
                                        break;
                                }
                        }
                });
                incrementThread5.start();

                Thread incrementThread6 = new Thread(() -> {            //sets happiness lower if gnoxi is hungry/tired

                        while (!menuPause && currentGnoxi.getHappiness() > 0) {
                                if (currentGnoxi.getHappiness() >= 100) {
                                        currentGnoxi.setHappiness(100);
                                }
                                if (currentGnoxi.getHunger() > 60 && currentGnoxi.getEnergy() > 60 && currentGnoxi.getHappiness()<100) {
                                        currentGnoxi.setHappiness(currentGnoxi.getHappiness() + 3);
                                }
                                if (currentGnoxi.getHunger() < 70) {
                                        currentGnoxi.setHappiness(currentGnoxi.getHappiness() - 1);
                                }
                                if (currentGnoxi.getHunger() < 60 && currentGnoxi.getHunger() < 30) {
                                        currentGnoxi.setHappiness(currentGnoxi.getHappiness() - 1);
                                }
                                if (currentGnoxi.getEnergy() < 70) {
                                        currentGnoxi.setHappiness(currentGnoxi.getHappiness() - 1);
                                }
                                if (currentGnoxi.getEnergy() < 60 && currentGnoxi.getEnergy() < 30) {
                                        currentGnoxi.setHappiness(currentGnoxi.getHappiness() - 1);
                                }
                                if (currentGnoxi.hasScarf() && currentGnoxi.getHappiness() < 70) {   //scarf gives happiness
                                        currentGnoxi.setHappiness(currentGnoxi.getHappiness() + 2);
                                }

                                try {
                                        Thread.sleep(2000); // Pause the thread
                                } catch (InterruptedException e) {
                                        // If the thread is interrupted, break out of the loop
                                        System.out.println(e);
                                        break;
                                }
                        }
                });
                incrementThread6.start();


                JPanel Interaction = new JPanel();                          //Interaction panel
                Interaction.setOpaque(false);
                sleep.setBorder(new EmptyBorder(0, 0, 0, 00));
                sleep.setContentAreaFilled(false);

                Interaction.add(sleep);
                Interaction.setLayout(new FlowLayout(FlowLayout.LEFT, 70, 0));


                JPanel GnoxiPanel = new JPanel();
                this.GnoxiPanel = GnoxiPanel;
                GnoxiPanel.setLayout(new GridBagLayout());
                GnoxiPanel.setOpaque(false);

                GridBagConstraints d = new GridBagConstraints();
                GnoxiPanel.setBorder(new EmptyBorder(20, 10, 17, 10));
                d.weighty = 0.1;
                d.fill = GridBagConstraints.VERTICAL;
                d.gridx = 0;
                d.gridy = 1;
                GnoxiPanel.add(StatusField, d);          //sets all labels up nicely, shop is separate
                d.weighty = 0.5;
                d.fill = GridBagConstraints.VERTICAL;
                d.gridx = 0;
                d.gridy = 2;
                d.ipady = 40;
                GnoxiPanel.add(gnoxi, d);
                d.ipady = 10;
                d.weighty = 0.1;
                d.fill = GridBagConstraints.BOTH;
                d.gridx = 0;
                d.gridy = 3;
                GnoxiPanel.add(Interaction, d);


                //FRAME
                JFrame frame = new JFrame("GnoxiWorld");               //Main frame
                this.frame = frame;
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(700, 500);
                frame.setLocationRelativeTo(null);
                frame.setIconImage(logoIcon.getImage());
                frame.setResizable(false);
                frame.setVisible(true);
                frame.setLayout(new BorderLayout());
                background = new JLabel();  //adds cool background
                background.setIcon(backgroundIcon);
                background.setOpaque(false);
                frame.setContentPane(background);
                frame.setLayout(new GridBagLayout());
                GridBagConstraints c = new GridBagConstraints();
                c.weightx = 0.5;
                c.weighty = 1;
                c.fill = GridBagConstraints.HORIZONTAL;
                c.gridx = 0;
                c.gridheight = 5;
                frame.add(GnoxiPanel, c);
                c.gridheight = 1;
                c.weighty = 0;
                c.weightx = 0.1;
                c.gridx = 3;
                c.gridy = 1;
                c.fill = GridBagConstraints.HORIZONTAL;
                frame.add(shopPanel, c);
                c.gridy = 0;
                d.ipady = 0;
                c.gridx = 3;
                c.fill = GridBagConstraints.CENTER;
                frame.add(gold, c);


                if (currentGnoxi.getSleeping()) {             //gnoxi stills sleeps after closing program
                        frame.setSize(540, 500);
                        if (Menu.onOff == 1) {    //plays music if it's turned ON
                                Menu.musicPlayer("Cascade");
                        }
                        currentGnoxi.setSleeping(true);
                        background.setIcon(backgroundIcon2);
                        currentGnoxi.setSleeping(true);
                        sleepLabel.setVisible(true);            //scene switch to sleeping
                        shopPanel.setVisible(false);
                        gold.setVisible(false);
                        GnoxiPanel.setBackground(new Color(52,51,97));
                }
        }
        public static void sfxPlayer(String title){     //sfx handling
                try {
                        AudioInputStream input = AudioSystem.getAudioInputStream(new File("Media/SoundFX/" + title + ".wav").getAbsoluteFile());
                        Clip sfx = AudioSystem.getClip();
                        sfx.open(input);
                        sfx.start();

                } catch (Exception ex) {
                        System.out.println("Error with playing sound.");
                        ex.printStackTrace();
                }
        }
        private class ButtonHandler implements ActionListener {
                public void actionPerformed(ActionEvent e) {

                        if (e.getSource()==sleep){
                                if (currentGnoxi.getSleeping()){

                                        if(Menu.onOff==1) {    //plays music if it's turned ON
                                                Menu.musicPlayer("It's Okay");
                                        }
                                        frame.setSize(700,500);
                                        currentGnoxi.setSleeping(false);
                                        background.setIcon(backgroundIcon);
                                        currentGnoxi.setSleeping(false);
                                        sleepLabel.setVisible(false);           //scene switch to lobby
                                        shopPanel.setVisible(true);
                                        gold.setVisible(true);

                                }
                                else {

                                        if(Menu.onOff==1) {
                                                Menu.musicPlayer("Cascade");
                                        }
                                        frame.setSize(540,500);
                                        currentGnoxi.setSleeping(true);
                                        background.setIcon(backgroundIcon2);
                                        currentGnoxi.setSleeping(true);
                                        sleepLabel.setVisible(true);            //scene switch to sleeping
                                        shopPanel.setVisible(false);
                                        gold.setVisible(false);
                                        GnoxiPanel.setBackground(new Color(52,51,97));
                                }
                        }

                        if (e.getSource() == randPoop){
                                currentGnoxi.setGold(currentGnoxi.gold +=13);   //gives gold when poop is pressed
                                if (currentGnoxi.hasBow()){ //poop buff
                                        currentGnoxi.setGold(currentGnoxi.gold +=10);
                                }
                                randPoop.setVisible(false);
                                hasPooped = false;
                        }

                        if(e.getSource()==aboutInfo){
                                JOptionPane.showMessageDialog(null, "You need to always keep the three main parameters above 0.\n" +
                                        "The three main parameters are:\n" +
                                        "Energy, Happiness and Hunger.\n" +
                                        "\n" +
                                        "Energy:\n" +
                                        "To keep your energy up you can either:\n" +
                                        "-Let your gnoxi sleep\n" +
                                        "-Buy energy drinks\n" +
                                        "\n" +                                  //Popup window, with tutorial text
                                        "Happiness:\n" +
                                        "Your gnoxi's happiness will automatically go up or down,\n" +
                                        "It depends on how you good you are at managing your gnoxi's two other stats. \n" +
                                        "When your happiness is in the greens, you will earn a small amount of money periodically.\n" +
                                        "\n" +
                                        "Hunger:\n" +
                                        "Remember to always keep your gnoxi fed.\n" +
                                        "You can do this by buying food in the shop.\n" +
                                        "\n" +
                                        "Shop:\n" +
                                        "In the shop you can buy different things like consumables and cosmetics. \n" +
                                        "WARNING cosmetics can be fun, but remember to have enough gold to feed your pet or it will die \n" +
                                        "(if you just want a pretty corpse that's fine).\n" +
                                        "\n" +
                                        "Poo:\n" +
                                        "Your gnoxi is a real animal, and like all other animals it poops.\n" +
                                        "Whenever you pick up after your gnoxi you will receive  a small amount of gold.\n" +
                                        "\n" +
                                        "Types of gnoxi:\n" +
                                        "There are 3 normal types of gnoxi:\n" +
                                        "GnoxiBear   (Common)\n" +
                                        "GnoxiPenguin (Uncommon) \n" +
                                        "GnoxiRabbit  (Rare)\n" +
                                        "You can also run into the GnoxiGnoxi, but that's just a myth\n" +
                                        " \n", "Tutorial", JOptionPane.INFORMATION_MESSAGE);

                        }
                        if(e.getSource()==menuBack){
                                menuPause=true;
                                frame.dispose();
                                Gnoxi.save();   //saves gnoxi, plays menu music, and starts new menu
                                if(Menu.onOff==1) {
                                        Menu.musicPlayer("Limerence");
                                }
                                new Menu ();
                        }

                        if (e.getSource() == item1) {

                                if(!shop.buy(1)){       //do this if (poor==true)
                                        JOptionPane.showMessageDialog(item1,"You dont have enough gold","Shop", JOptionPane.ERROR_MESSAGE);
                                }
                                else if (currentGnoxi.getHunger() == 100) {
                                        return;
                                }
                                else if (currentGnoxi.getHunger() + 10 > 100) {
                                        sfxPlayer("nomSound");  //nom
                                        currentGnoxi.setHunger(100);
                                        progressBar.setValue(currentGnoxi.getHunger());
                                }
                                else {
                                        sfxPlayer("nomSound");  //nom
                                        currentGnoxi.setHunger(currentGnoxi.getHunger() + 10);  //sets value higher
                                        progressBar.setValue(currentGnoxi.getHunger());         //updates progressbar
                                }

                        }
                        if (e.getSource() == item2) {

                                if(!shop.buy(2)){       //poor
                                        JOptionPane.showMessageDialog(item2,"You dont have enough gold","Shop", JOptionPane.ERROR_MESSAGE);
                                }
                                else if (currentGnoxi.getEnergy() == 100){
                                        return;
                                }
                                else if (currentGnoxi.getEnergy()+10 > 100){
                                        sfxPlayer("sipSound");  //coffee sound
                                        currentGnoxi.setEnergy(100);
                                        progressBar3.setValue(currentGnoxi.getEnergy());

                                }
                                else {
                                        sfxPlayer("sipSound");  //sssssiip
                                        currentGnoxi.setEnergy(currentGnoxi.getEnergy()+10); //sets value higher
                                        progressBar3.setValue(currentGnoxi.getEnergy()); //updates progressbar
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
                                        sfxPlayer("slurpSound");  //lolli sluurp
                                        currentGnoxi.setHappiness(100);
                                        progressBar2.setValue(currentGnoxi.getHappiness());

                                }
                                else {
                                        sfxPlayer("slurpSound");  //Slurp
                                        currentGnoxi.setHappiness(currentGnoxi.getHappiness()+5); //sets value higher
                                        progressBar2.setValue(currentGnoxi.getHappiness()); //updates progressbar
                                }
                        }

                        if (e.getSource() == item4) {
                                if (bowLabel.isVisible()) {     //returns if already bought
                                        JOptionPane.showMessageDialog(item4, "Already owned", "Shop", JOptionPane.ERROR_MESSAGE);
                                        return;
                                }

                                else {
                                        if(!shop.buy(4)){   //poor
                                                JOptionPane.showMessageDialog(item4,"You dont have enough gold","Shop", JOptionPane.ERROR_MESSAGE);
                                        }
                                        else {
                                                shop.buy(4);
                                                item4.setOpaque(false);
                                                item4.setIcon(shopBow2);  //sets checkmark in shop
                                                bowLabel.setVisible(true);
                                                currentGnoxi.setBow(true);
                                                item4.setRolloverIcon(shopBow2);
                                                item4.repaint();
                                        }
                                }
                        }
                        if (e.getSource() == item5) {
                                if (tophatLabel.isVisible()) {        //returns if already bought
                                        JOptionPane.showMessageDialog(item5, "Already owned", "Shop", JOptionPane.ERROR_MESSAGE);
                                        return;
                                }

                                else {
                                        if(!shop.buy(5)){   //poor
                                                JOptionPane.showMessageDialog(item5,"You dont have enough gold","Shop", JOptionPane.ERROR_MESSAGE);
                                        }
                                        else {
                                                shop.buy(5);
                                                item5.setOpaque(false);
                                                item5.setIcon(topHatIcon2);  //sets checkmark in shop
                                                tophatLabel.setVisible(true);
                                                currentGnoxi.setTophat(true);
                                                item5.setRolloverIcon(topHatIcon2);
                                                item5.repaint();
                                        }
                                }
                        }
                        if (e.getSource() == item6) {
                                if (scarfLabel.isVisible()) {    //returns if already bought
                                        JOptionPane.showMessageDialog(item6, "Already owned", "Shop", JOptionPane.ERROR_MESSAGE);
                                        return;
                                }

                                else {
                                        if(!shop.buy(6)){   //poor
                                                JOptionPane.showMessageDialog(item6,"You dont have enough gold","Shop", JOptionPane.ERROR_MESSAGE);
                                        }
                                        else {
                                                shop.buy(5);
                                                item6.setOpaque(false);
                                                item6.setIcon(scarfIcon2); //sets checkmark in shop
                                                scarfLabel.setVisible(true);
                                                currentGnoxi.setScarf(true);
                                                item6.setRolloverIcon(scarfIcon2);
                                                item6.repaint();
                                        }
                                }
                        }
                        gold.setText(currentGnoxi.getGold()+"");
                }
        }
}