/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Books;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
/**
 *
 * @author OSCAR DANIEL SALAZAR CEBALLOS....  CODIGO 2140341356
 */
public class BooksStore extends Frame{
    private TextField book;
    private Button add;
    private List enalble;
    private List disable;
    private Button remove;
    private Button clear;
    private Button men;
    private Button mayor;
    //----------------------------------------------------------------------------------------
    public BooksStore()
    {
        Panel p = new Panel(new BorderLayout());
        Panel pc = new Panel(new GridLayout(1,2));
        Panel pa = new Panel(new GridLayout(1,4));
        Panel titulos = new Panel(new GridLayout(1,2));
        BorderLayout b1 = new BorderLayout();
        book = new TextField();
        add = new Button("add");
        clear = new Button("clear");
        men = new Button("<");
        mayor = new Button(">");
        enalble = new List();
        disable = new List();
        remove = new Button("Remove");
        
        titulos.add(new Label("Enable"));
        titulos.add(new Label("Disable"));
        
        p.add(new Label("title"), BorderLayout.WEST);
        p.add(book, BorderLayout.CENTER);
        p.add(add, BorderLayout.EAST);
        p.add(titulos,BorderLayout.SOUTH);
    
        pc.add(enalble);
        pc.add(disable);
       
        pa.add(remove);
        pa.add(men);
        pa.add(mayor);
        pa.add(clear);
                     
        add(p,BorderLayout.NORTH);
        add(pc,BorderLayout.CENTER);
        add(pa,BorderLayout.SOUTH);
        
        setTitle("BOOKS STORE");
        setSize(400,300);
        evens();
        setVisible(true);
    }
    //--------------------------------------------------------------------------
    private void evens()
    {
        //----------- closing window and system-------------------
        addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e)
            {
                dispose();
                System.exit(0);
            }
        } );
        //------------------------------------------
            //añade haciendo clikc en add
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enalble.add(book.getText());
                book.setText("");
            }
        });       
        //------------------------------------------------------       
        remove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             enalble.remove(enalble.getSelectedIndex());      
            }
        });
        //-------------------------------------------------------
            //añade presionando enter
          book.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enalble.add(book.getText());
                book.setText("");
            }
        });         
        //-----------------------menor----------------------------------
        men.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enalble.add(disable.getSelectedItem());
                disable.remove(disable.getSelectedIndex());                                            
            }
        });            
        //-----------------------mayor----------------------------------
        mayor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                disable.add(enalble.getSelectedItem());
                enalble.remove(enalble.getSelectedIndex());        
            }        
        });                    
        //----------------clear----------------------------------------
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                disable.getSelectedItems();
                disable.removeAll();               
                enalble.getSelectedItems();
                enalble.removeAll();                                           
            }
        });      
    } 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         new BooksStore();
    }  
}