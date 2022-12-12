import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class GUI{
        static Gnoxi currentGnoxi;
        public Shop shop = new Shop();

        private JButton item1;
        private JButton item2;
        private JButton item3;
        private JButton item4;
        private JButton item5;
        private JButton item6;
        private JLabel gold;
        private JPopupMenu itemBought; //UNUSED
        private JFrame frame;


        public static void newGnoxi(){            //asks user to input name
                String nameQuery = JOptionPane.showInputDialog("Enter the name of your Gnoxi");
                Gnoxi currentGnoxi = new Gnoxi(nameQuery, 0, 10, 0, 0, 10, System.currentTimeMillis(), 0);      //creates new gnoxi
                FileIO.writeGnoxi(currentGnoxi);  //saves gnoxi to CSV
                new GUI(currentGnoxi);            //starts GUI
        }

        public static void oldGnoxi(){
                currentGnoxi=FileIO.createOldGnoxi();
                new GUI(currentGnoxi);
        }
        public void death(){

                //kill gnoxi here

                int result = JOptionPane.showConfirmDialog(frame, "Your Gnoxi has died \n Start new game?","Death",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);

                if(result == JOptionPane.YES_OPTION){
                        new Menu();
                }else if (result == JOptionPane.NO_OPTION){
                        System.exit(0);
                }
        }
        public GUI(Gnoxi currentGnoxi) {
                this.currentGnoxi=currentGnoxi;

                //ICONS

                ImageIcon logoIcon = new ImageIcon("Media/gnoxiIcon.png");                        //logo
                ImageIcon gnoxiIcon = new ImageIcon("Media/Gnoxi/gnoxiRabbit.png");               //Gnoxi
                ImageIcon sleepIcon = new ImageIcon("Media/Interaction/sleepIcon.png");           //sleep
                ImageIcon cleanIcon = new ImageIcon("Media/Interaction/cleanIcon.png");           //clean
                ImageIcon feedIcon = new ImageIcon("Media/Interaction/feedIcon.png");             //feed
                ImageIcon foodIcon = new ImageIcon("Media/ShopIcons/foodIcon.png");               //food1
                ImageIcon energyDrinkIcon = new ImageIcon("Media/ShopIcons/energyDrinkIcon.png"); //energy drink
                ImageIcon happinessIcon = new ImageIcon("Media/StatusBars/happiness.png");       //happiness
                ImageIcon hungerIcon = new ImageIcon("Media/StatusBars/hunger.png");             //hunger
                ImageIcon energyIcon = new ImageIcon("Media/StatusBars/energy.png");             //energy
                ImageIcon goldIcon = new ImageIcon("Media/ShopIcons/goldIcon.png");               //gold


                ButtonHandler handler = new ButtonHandler();

                //BUTTONS

                JButton sleep = new JButton();
                sleep.setIcon(sleepIcon);
                sleep.setBackground(ColorUIResource.WHITE);


                JButton clean = new JButton();
                clean.setIcon(cleanIcon);
                clean.setBackground(ColorUIResource.WHITE);

                JButton feed = new JButton();
                feed.setIcon(feedIcon);
                feed.setBackground(ColorUIResource.WHITE);


                //SHOP BUTTONS


                JButton item1 = new JButton();
                this.item1=item1;
                item1.setIcon(foodIcon);
                item1.setBackground(ColorUIResource.WHITE);
                item1.setVerticalTextPosition(JLabel.CENTER);
                item1.addActionListener(handler);
                item1.setText("Food: 5g");
                item1.setToolTipText("Adds 1+ food");

                JButton item2 = new JButton();
                this.item2 = item2;
                item2.setBackground(ColorUIResource.WHITE);
                item2.setIcon(energyDrinkIcon);
                item2.setVerticalTextPosition(JLabel.CENTER);
                item2.addActionListener(handler);
                item2.setText("E-Drink: 15g");

                JButton item3 = new JButton();
                this.item3 = item3;
                item3.addActionListener(handler);
                item3.setBackground(ColorUIResource.WHITE);

                JButton item4 = new JButton();
                this.item4 = item4;
                item4.setBackground(ColorUIResource.WHITE);

                JButton item5 = new JButton();
                this.item5 = item5;
                item5.setBackground(ColorUIResource.WHITE);

                JButton item6 = new JButton();
                this.item6 = item6;
                item6.setBackground(ColorUIResource.WHITE);

                JPopupMenu itemBought = new JPopupMenu();
                this.itemBought = itemBought;    // UNUSED
                itemBought.add("Item bought");




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




                JProgressBar progressBar = new JProgressBar();
                JLayeredPane layeredPane = new JLayeredPane();
                layeredPane.add(progressBar,0);
                ImageIcon icon = new ImageIcon("Media/StatusBars/energy.png");
                BufferedImage image = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
                Graphics2D g = image.createGraphics();
                g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
                g.drawImage(icon.getImage(), 0, 0, null);
                g.dispose();

                JLabel imageLabel = new JLabel(new ImageIcon(image));
                layeredPane.add(imageLabel, 1);
                progressBar.setMaximum(100);
                progressBar.setStringPainted(true);
                progressBar.setOrientation(JProgressBar.VERTICAL);
                progressBar.setPreferredSize(new Dimension(40, 40));

                JProgressBar progressBar2 = new JProgressBar();
                progressBar2.setOrientation(JProgressBar.VERTICAL);
                progressBar2.setPreferredSize(new Dimension(40, 40));
                JProgressBar progressBar3 = new JProgressBar();
                progressBar3.setOrientation(JProgressBar.VERTICAL);
                progressBar3.setPreferredSize(new Dimension(40, 40));

                // Add the progress bar to a container
                Container container = StatusField;
                a.gridx = 0;
                a.gridy = 1;
                container.add(layeredPane,a);
                a.gridx = 1;
                a.gridy = 1;
                container.add(progressBar2,a);
                a.gridx = 2;
                a.gridy = 1;
                container.add(progressBar3,a);

                // Create a new thread for the incrementing function
                Thread incrementThread = new Thread(() -> {
                        int hunger= currentGnoxi.getHunger();

                        while (hunger>0) {
                                currentGnoxi.setHunger(hunger--);

                                progressBar.setValue(hunger);
                                if (hunger < 30) {
                                        progressBar.setForeground(Color.RED);
                                } else if (hunger > 30 && hunger < 60){
                                        progressBar.setForeground(Color.yellow);
                                }
                                else{
                                        progressBar.setForeground(Color.green);
                                }

                                try {
                                        Thread.sleep(100); // real milis 2592000
                                } catch (InterruptedException e) {
                                        // If the thread is interrupted, break out of the loop
                                        break;
                                }
                        }

                });

                incrementThread.start();
                Thread incrementThread2 = new Thread(() -> {
                        int happiness = currentGnoxi.getHappiness();

                        while (happiness>0) {
                                currentGnoxi.setHappiness(happiness--);

                                progressBar2.setValue(happiness);
                                if (happiness < 30) {
                                        progressBar2.setForeground(Color.RED);
                                } else if (happiness > 30 && happiness < 60){
                                        progressBar2.setForeground(Color.yellow);
                                }
                                else{
                                        progressBar2.setForeground(Color.green);
                                }

                                try {
                                        Thread.sleep(100); // Pause the thread for 10 seconds
                                } catch (InterruptedException e) {
                                        // If the thread is interrupted, break out of the loop
                                        break;
                                }
                        }

                });
                incrementThread2.start();
                Thread incrementThread3 = new Thread(() -> {
                        int energy= currentGnoxi.getEnergy();

                        while (energy>0) {
                                currentGnoxi.setEnergy(energy--);

                                progressBar3.setValue(energy);
                                if (energy < 30) {
                                        progressBar3.setForeground(Color.RED);
                                } else if (energy > 30 && energy < 60){
                                        progressBar3.setForeground(Color.yellow);
                                }
                                else{
                                        progressBar3.setForeground(Color.green);
                                }

                                try {
                                        Thread.sleep(100); // Pause the thread for 10 seconds
                                } catch (InterruptedException e) {
                                        // If the thread is interrupted, break out of the loop
                                        break;
                                }
                        }

                });

                incrementThread3.start();


                JPanel Gnoxi = new JPanel();                                //Gnoxi panel
                Gnoxi.setBackground(ColorUIResource.PINK);
                Gnoxi.add(gnoxi1);

                JPanel Interaction = new JPanel();                          //Interaction panel
                Interaction.setBackground(ColorUIResource.PINK);
                Interaction.add(sleep);
                Interaction.add(clean);
                Interaction.add(feed);
                Interaction.setLayout(new FlowLayout(FlowLayout.CENTER,50,0));

                JPanel GnoxiPanel = new JPanel();
                GnoxiPanel.setLayout(new GridBagLayout());
                GnoxiPanel.setBackground(ColorUIResource.PINK);
                GridBagConstraints d = new GridBagConstraints();
                GnoxiPanel.setBorder(new EmptyBorder(20,10,27,10));
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
                GnoxiPanel.add(Gnoxi,d);
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
                c.gridheight=3;
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


        }
        private class ButtonHandler implements ActionListener {
                public void actionPerformed(ActionEvent e) {

                        if (e.getSource() == item1) {
                                shop.buy(1);
                        }
                        if (e.getSource() == item2) {
                                shop.buy(2);
                        }
                        if (e.getSource() == item3) {
                                //shop.buy(3);
                                death();
                        }
                        if (e.getSource() == item4) {
                                shop.buy(4);
                        }
                        if (e.getSource() == item5) {
                                shop.buy(5);
                        }
                        if (e.getSource() == item6) {
                                shop.buy(6);
                        }

                        gold.setText(currentGnoxi.getGold()+"g");
                }
        }

}