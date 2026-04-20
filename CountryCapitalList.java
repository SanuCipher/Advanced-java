/*5c. Develop a Swing program in Java to add the countries USA, India, Vietnam, Canada, Denmark,
France, Great Britain, Japan, Africa, Greenland, Singapore into a JList and display the capital of the
countries on console whenever the countries are selected on the list.*/


package swings;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
public class CountryCapitalList extends JFrame {
private JList<String> countryList;
public CountryCapitalList() {
DefaultListModel<String> listModel = new DefaultListModel<>();
listModel.addElement("USA");
listModel.addElement("India");
listModel.addElement("Vietnam");
listModel.addElement("Canada");
listModel.addElement("Denmark");
listModel.addElement("France");
listModel.addElement("Great Britain");
listModel.addElement("Japan");
listModel.addElement("Africa");
listModel.addElement("Greenland");
listModel.addElement("Singapore");
countryList = new JList<>(listModel);
countryList.addListSelectionListener(new ListSelectionListener() {
@Override
public void valueChanged(ListSelectionEvent e) {
if (!e.getValueIsAdjusting()) {
final List<String> selectedValuesList = countryList.getSelectedValuesList();
for (String country : selectedValuesList) {
switch (country) {
case "USA": System.out.println("Capital of USA is: Washington D.C."); break;
case "India": System.out.println("Capital of India is: New Delhi"); break;
case "Vietnam": System.out.println("Capital of Vietnam is: Hanoi"); break;
case "Canada": System.out.println("Capital of Canada is: Ottawa"); break;
case "Denmark": System.out.println("Capital of Denmark is: Copenhagen"); break;
case "France": System.out.println("Capital of France is: Paris"); break;
case "Great Britain": System.out.println("Capital of Great Britain is: London"); break;
case "Japan": System.out.println("Capital of Japan is: Tokyo"); break;
case "Africa": System.out.println("Capital of Africa is: Addis Ababa"); break;
case "Greenland": System.out.println("Capital of Greenland is: Nuuk"); break;
case "Singapore": System.out.println("Capital of Singapore is: Singapore"); break;
}
}
}
}
});
add(new JScrollPane(countryList));
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
this.setTitle("Country Capital List");
this.setSize(250,250);
this.setLocationRelativeTo(null);
this.setVisible(true);
}
public static void main(String[] args) {
new CountryCapitalList();
}
}