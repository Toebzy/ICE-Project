import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;

public class GUI{
        static Gnoxi currentGnoxi;
        public Shop shop = new Shop();

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
        public GUI(Gnoxi currentGnoxi) {
                this.currentGnoxi=currentGnoxi;


                shop.buy(1);    //TEST OF SHOP


                                                 //ICONS

                ImageIcon logoIcon = new ImageIcon("Media/gnoxiIcon.png");                     //logo
                ImageIcon gnoxiIcon = new ImageIcon("Media/Gnoxi/gnoxiRabbit.png");              //Gnoxi
                ImageIcon sleepIcon = new ImageIcon("Media/Interaction/sleepIcon.png");        //sleep
                ImageIcon cleanIcon = new ImageIcon("Media/Interaction/cleanIcon.png");        //clean
                ImageIcon feedIcon = new ImageIcon("Media/Interaction/feedIcon.png");          //feed
                ImageIcon foodIcon = new ImageIcon("Media/ShopIcons/foodIcon.png");            //food
                ImageIcon happinessIcon = new ImageIcon("Media/StatusBars/happiness5.png");    //happiness
                ImageIcon hungerIcon = new ImageIcon("Media/StatusBars/hunger5.png");          //hunger
                ImageIcon energyIcon = new ImageIcon("Media/StatusBars/energy5.png");          //energy
                ImageIcon goldIcon = new ImageIcon("Media/ShopIcons/goldIcon.png");            //gold

                                                //BUTTONS

                JButton sleep = new JButton();
                // sleep.press
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
                item1.setIcon(foodIcon);
                item1.setBackground(ColorUIResource.WHITE);
                item1.setVerticalTextPosition(JLabel.TOP);
                item1.setText("Food: 5g");
                JButton item2 = new JButton();
                item2.setBackground(ColorUIResource.WHITE);
                JButton item3 = new JButton();
                item3.setBackground(ColorUIResource.WHITE);
                JButton item4 = new JButton();
                item4.setBackground(ColorUIResource.WHITE);
                JButton item5 = new JButton();
                item5.setBackground(ColorUIResource.WHITE);
                JButton item6 = new JButton();
                item6.setBackground(ColorUIResource.WHITE);

                                                //LABELS

                JLabel gold = new JLabel();
                gold.setBorder(new EmptyBorder(20,0,20,0));
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
                hungerStat.setVerticalTextPosition(JLabel.TOP);
                hungerStat.setHorizontalTextPosition(JLabel.CENTER);
                hungerStat.setFont(new Font("Arial", Font.BOLD, 12));
                hungerStat.setIcon(hungerIcon);


                JLabel happinessStat = new JLabel();
                happinessStat.setText("Happiness");
                happinessStat.setVerticalTextPosition(JLabel.TOP);
                happinessStat.setHorizontalTextPosition(JLabel.CENTER);
                happinessStat.setFont(new Font("Arial", Font.BOLD, 12));
                happinessStat.setIcon(happinessIcon);


                JLabel energyStat = new JLabel();
                energyStat.setText("Energy");
                energyStat.setVerticalTextPosition(JLabel.TOP);
                energyStat.setHorizontalTextPosition(JLabel.CENTER);
                energyStat.setFont(new Font("Arial", Font.BOLD, 12));
                energyStat.setIcon(energyIcon);

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
                StatusField.add(hungerStat);
                StatusField.add(happinessStat);
                StatusField.add(energyStat);
                StatusField.setLayout(new FlowLayout(FlowLayout.CENTER,50,0));



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
                GnoxiPanel.setBackground((ColorUIResource.PINK));
                GridBagConstraints d = new GridBagConstraints();
                GnoxiPanel.setBorder(new EmptyBorder(20,10,10,10));
                d.weighty = 0.1;
                d.fill = GridBagConstraints.VERTICAL;
                d.gridx = 0;
                d.gridy = 1;
                d.ipady=30;
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

}