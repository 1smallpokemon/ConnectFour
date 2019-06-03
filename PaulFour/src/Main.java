import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JList.DropLocation;

public class Main
{  
  public static void main(String[] args)
  {
    EventQueue.invokeLater(new Runnable(){
      public void run()
      {
        ConnectFourFrame aFrame = new ConnectFourFrame();
        aFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        aFrame.setVisible(true);
      }
    });
  }
}

class ConnectFourFrame extends JFrame
{
  public static final int DEFAULT_WIDTH = 700;
  public static final int DEFAULT_HEIGHT = 850;

  public ConnectFourFrame()
  {
    this.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    this.setTitle("Paul's Connect Four");
    ConnectFourPanel panel = new ConnectFourPanel();
    this.add(panel);

  }
}

class ConnectFourPanel extends JPanel
{
  public static final int NUM_ROWS = 6;
  public static final int NUM_COLS = 7;

  JLabel[][] tiles = new JLabel[6][7];
  JPanel northPanel = new JPanel();
  JPanel centerPanel = new JPanel();
  JPanel southPanel = new JPanel();

  JLabel nameLabel = new JLabel("Soetaert Connect Four");
  JButton clearButton = new JButton("reset");
  
  boolean isXTurn = true; //if true, place an X. If false, place an O.

  public ConnectFourPanel(){



    Font myFont = new Font("Serif", Font.BOLD, 24);
    this.setLayout(new BorderLayout());
    this.add(northPanel, BorderLayout.NORTH);
    this.add(centerPanel, BorderLayout.CENTER);
    this.add(southPanel, BorderLayout.SOUTH);

    northPanel.setLayout(new GridLayout(1, NUM_COLS));
    for(int i = 0; i < NUM_COLS; i++){
      JButton dropButton = new JButton("Col " + i);
      dropButton.setFont(new Font("Serif", Font.BOLD, 20));
      dropButton.addActionListener(new tileActionListener());
      northPanel.add(dropButton);
    }
  
    //Give a clear border
    centerPanel.setBorder(BorderFactory.createRaisedBevelBorder());
    centerPanel.setLayout(new GridLayout(NUM_ROWS, NUM_COLS));
    
    for(int i = 0; i < NUM_ROWS; i++){

      for(int j = 0; j < NUM_COLS; j++){
        tiles[i][j] = new JLabel(" ");
        tiles[i][j].setHorizontalAlignment(JLabel.CENTER);
        tiles[i][j].setOpaque(true);
        tiles[i][j].setBorder(BorderFactory.createRaisedBevelBorder());
        centerPanel.add(tiles[i][j]);
      }
    }
  
    //Clear button
    clearButton.setFont(myFont);
    clearButton.addActionListener(new tileActionListener());
    southPanel.add(clearButton);
  } 

  class tileActionListener implements ActionListener
  {

    public void actionPerformed(ActionEvent event)
    {
      JButton clickedButton = (JButton) event.getSource(); //find out what button was clicked

      //If they clicked reset, reset the game
      if(clickedButton == clearButton)
      {
        for(int i = 0; i < NUM_ROWS; i++){
          for(int j = 0; j < NUM_COLS; j++){
            tiles[i][j].setText(" ");
            isXTurn = true;
          }
        }
      }
      else
      {
        dropItem(clickedButton.getText());
      }
    }
  }

  void dropItem(String colName)
  {

    int colNum = Integer.parseInt(colName.substring(colName.length() - 1));

    //i = 5
    int i = NUM_ROWS-1;
    boolean validMove = true;

    while(tiles[i][colNum].getText() != " "){
      if(i <= 0){
        System.out.println("Column is full!");
        validMove = false;
        break;
      }
      else{
        i--;
        validMove = true;
      }
    }
    if(isXTurn && validMove){
      tiles[i][colNum].setText("O");
      tiles[i][colNum].setFont(new Font("Serif", Font.BOLD, 50));
      tiles[i][colNum].setForeground(Color.RED);
      isXTurn = false;

    }
    else if(!isXTurn && validMove)
    {
      tiles[i][colNum].setText("O");
      tiles[i][colNum].setFont(new Font("Serif", Font.BOLD, 50));
      tiles[i][colNum].setForeground(Color.BLUE);
      isXTurn = true;
    }
  }
}
