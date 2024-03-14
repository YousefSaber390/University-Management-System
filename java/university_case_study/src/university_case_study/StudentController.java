package university_case_study;

import DTO.DTO_courses;
import DTO.DTO_departments;
import DTO.DTO_enroll;
import DTO.DTO_instractors;
import DTO.DTO_students;
import DTO.DTO_test;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author yousef saber
 */
public class StudentController implements Initializable {

    @FXML
    private AnchorPane deptview;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    ////////////////////////////////////////////////////////////////////////////
    //student_scene
    @FXML
    private Button studentform_btn;
    @FXML
    private AnchorPane students_form;
    @FXML
    private TableView<DTO_students> students_tabel_view;
    @FXML
    private TableColumn<DTO_students, Integer> student_id;
    @FXML
    private TableColumn<DTO_students, String> f_name;
    @FXML
    private TableColumn<DTO_students, String> l_name;
    @FXML
    private TableColumn<DTO_students, String> email;
    @FXML
    private TableColumn<DTO_students, String> DOB;
    @FXML
    private TableColumn<DTO_students, String> city;
    @FXML
    private TableColumn<DTO_students, String> street;
    @FXML
    private TableColumn<DTO_students, String> nationality;
    @FXML
    private TableColumn<DTO_students, Double> GPA;
    @FXML
    private TableColumn<DTO_students, Integer> s_departments_id;
    @FXML
    private TableColumn<DTO_students, Double> phone_number;
    @FXML
    private TextField TFS_student_id;
    @FXML
    private TextField TFS_F_name;
    @FXML
    private TextField TFS_l_name;
    @FXML
    private TextField TFS_street;
    @FXML
    private DatePicker TFS_date;
    @FXML
    private Button s_addbtn;
    @FXML
    private Button s_updatebtn;
    @FXML
    private Button s_clearbtn;
    @FXML
    private Button s_deletebtn;
    @FXML
    private TextField TFS_city;
    @FXML
    private TextField TFS_nationality;
    @FXML
    private TextField TFS_department_id;
    @FXML
    private TextField TFS_GPA;
    @FXML
    private TextField TFS_email;
    @FXML
    private Label studentview_student_id_label111;
    @FXML
    private TextField TFS_phone_number;

    public ObservableList<DTO_students> addStudentsListData() {
        ObservableList<DTO_students> listStudents = FXCollections.observableArrayList();
        String sql = "select * from Students";
        try {
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/university_case_study", "root", "yousefsaber_1999");
            DTO_students studentD;
            PreparedStatement prepare = connect.prepareStatement(sql);

            ResultSet result = prepare.executeQuery();
            while (result.next()) {
                studentD = new DTO_students(
                        result.getInt("student_id"),
                        result.getString("f_name"),
                        result.getString("l_name"),
                        result.getString("email"),
                        result.getString("DOB"),
                        result.getString("city"),
                        result.getString("street"),
                        result.getString("nationality"),
                        result.getDouble("GPA"),
                        result.getInt("department_id"),
                        result.getString("phone_number"));
                listStudents.add(studentD);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listStudents;
    }

    private ObservableList<DTO_students> addStudentsListD;

    private void addStudentsShowListData() {
        addStudentsListD = addStudentsListData();
        student_id.setCellValueFactory(new PropertyValueFactory<>("student_id"));
        f_name.setCellValueFactory(new PropertyValueFactory<>("f_name"));
        l_name.setCellValueFactory(new PropertyValueFactory<>("l_name"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        DOB.setCellValueFactory(new PropertyValueFactory<>("DOB"));
        city.setCellValueFactory(new PropertyValueFactory<>("city"));
        street.setCellValueFactory(new PropertyValueFactory<>("street"));
        nationality.setCellValueFactory(new PropertyValueFactory<>("nationality"));
        GPA.setCellValueFactory(new PropertyValueFactory<>("GPA"));
        s_departments_id.setCellValueFactory(new PropertyValueFactory<>("department_id"));
        phone_number.setCellValueFactory(new PropertyValueFactory<>("phone_number"));
        students_tabel_view.setItems(addStudentsListD);
    }

    @FXML
    private void loadstudents(ActionEvent event) {
        students_form.setVisible(true);
        courses_form.setVisible(false);
        gpa_form.setVisible(false);
        departement_form.setVisible(false);
        instractors_form.setVisible(false);
        enroll_form.setVisible(false);
        test_form.setVisible(false);

        addStudentsShowListData();
    }

    @FXML
    private void studentview_addaction(ActionEvent event) {
        try {
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/university_case_study", "root", "yousefsaber_1999");
            if (TFS_student_id.getText().isEmpty() || TFS_F_name.getText().isEmpty() || TFS_l_name.getText().isEmpty() || TFS_email.getText().isEmpty() || TFS_date.getValue()== null || TFS_city.getText().isEmpty() || TFS_street.getText().isEmpty() || TFS_nationality.getText().isEmpty() || TFS_GPA.getText().isEmpty() || TFS_department_id.getText().isEmpty() || TFS_phone_number.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else {
                String checkData = "SELECT student_id FROM students WHERE student_id = ?";
                PreparedStatement checkStatement = connect.prepareStatement(checkData);
                checkStatement.setString(1, TFS_student_id.getText());
                ResultSet result = checkStatement.executeQuery();
                if (result.next()) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Student #" + TFS_student_id.getText() + " already exists!");
                    alert.showAndWait();
                } else {
                    String insertData = "INSERT INTO students (student_id, f_name, l_name, email, DOB, city, street, nationality, GPA, department_id, phone_number) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    PreparedStatement prepare = connect.prepareStatement(insertData);
                    prepare.setString(1, TFS_student_id.getText());
                    prepare.setString(2, TFS_F_name.getText());
                    prepare.setString(3, TFS_l_name.getText());
                    prepare.setString(4, TFS_email.getText());
                    prepare.setString(5, TFS_date.getValue().toString());
                    prepare.setString(6, TFS_city.getText());
                    prepare.setString(7, TFS_street.getText());
                    prepare.setString(8, TFS_nationality.getText());
                    prepare.setString(9, TFS_GPA.getText());
                    prepare.setString(10, TFS_department_id.getText());
                    prepare.setString(11, TFS_phone_number.getText());
                    prepare.executeUpdate();
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Student added successfully!");
                    alert.showAndWait();
                    addStudentsShowListData();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("An error occurred while adding the student!");
            alert.showAndWait();
        }
    }

    @FXML
    private void studentview_updateaction(ActionEvent event) throws SQLException {

    StringBuilder updateBuilder = new StringBuilder("UPDATE students SET ");

    if (!TFS_F_name.getText().isEmpty()) {
        updateBuilder.append("F_name = '").append(TFS_F_name.getText()).append("', ");
    }

    if (!TFS_l_name.getText().isEmpty()) {
        updateBuilder.append("L_name = '").append(TFS_l_name.getText()).append("', ");
    }

    if (!TFS_email.getText().isEmpty()) {
        updateBuilder.append("email = '").append(TFS_email.getText()).append("', ");
    }

    if (TFS_date.getValue() != null) {
        updateBuilder.append("DOB = '").append(TFS_date.getValue()).append("', ");
    }


    if (!TFS_city.getText().isEmpty()) {
        updateBuilder.append("city = '").append(TFS_city.getText()).append("', ");
    }


    if (!TFS_street.getText().isEmpty()) {
        updateBuilder.append("street = '").append(TFS_street.getText()).append("', ");
    }

    if (!TFS_nationality.getText().isEmpty()) {
        updateBuilder.append("nationality = '").append(TFS_nationality.getText()).append("', ");
    }

    if (!TFS_GPA.getText().isEmpty()) {
        updateBuilder.append("GPA = '").append(TFS_GPA.getText()).append("', ");
    }

    if (!TFS_department_id.getText().isEmpty()) {
        updateBuilder.append("department_id = ").append(Integer.parseInt(TFS_department_id.getText())).append(", ");
    }

    if (!TFS_phone_number.getText().isEmpty()) {
        updateBuilder.append("phone_number = '").append(TFS_phone_number.getText()).append("', ");
    }

    updateBuilder.deleteCharAt(updateBuilder.length() - 2);

    updateBuilder.append(" WHERE student_id = ").append(Integer.parseInt(TFS_student_id.getText()));

    String update = updateBuilder.toString();

        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/university_case_study", "root", "yousefsaber_1999");
        Alert alert;
        if (TFS_student_id.getText().isEmpty()) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();
        } else {
            alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to UPDATE Student #" + TFS_student_id.getText() + "?");
            Optional<ButtonType> option = alert.showAndWait();
            if (option.get().equals(ButtonType.OK)) {
                Statement statement = connect.createStatement();
                statement.executeUpdate(update);

                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully Updated!");
                alert.showAndWait();
                addStudentsShowListData();

            }
        }
    }

    @FXML
    private void studentview_clearaction(ActionEvent event) {
        TFS_student_id.clear();
        TFS_F_name.clear();
        TFS_l_name.clear();
        TFS_email.clear();
        TFS_date.setValue(null);
        TFS_city.clear();
        TFS_street.clear();
        TFS_nationality.clear();
        TFS_GPA.clear();
        TFS_department_id.clear();
        TFS_phone_number.clear();
    }

    @FXML
    private void studentview_deleteaction(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to delete Student #" + TFS_student_id.getText() + "?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            try {
                String deletes = "DELETE FROM students WHERE student_id = ?";
                String deletee = "DELETE FROM enroll WHERE student_id = ?";
                String delete = "DELETE FROM test WHERE student_id = ?";


                Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/university_case_study", "root", "yousefsaber_1999");
                PreparedStatement statement1 = connect.prepareStatement(delete);
                PreparedStatement statement2 = connect.prepareStatement(deletee);
                PreparedStatement statement3 = connect.prepareStatement(deletes);
                statement1.setInt(1, Integer.parseInt(TFS_student_id.getText()));
                statement2.setInt(1, Integer.parseInt(TFS_student_id.getText()));
                statement3.setInt(1, Integer.parseInt(TFS_student_id.getText()));

                statement1.executeUpdate();
                statement2.executeUpdate();
                int rowsAffected = statement3.executeUpdate();

                if (rowsAffected > 0) {
                    Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                    successAlert.setTitle("Success");
                    successAlert.setHeaderText(null);
                    successAlert.setContentText("Student #" + TFS_student_id.getText() + " deleted successfully.");
                    successAlert.showAndWait();
                    addStudentsShowListData(); // Refresh the table after deletion
                } else {
                    Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                    errorAlert.setTitle("Error");
                    errorAlert.setHeaderText(null);
                    errorAlert.setContentText("Failed to delete Student #" + TFS_student_id.getText() + ".");
                    errorAlert.showAndWait();
                }
            } catch (SQLException ex) {
                Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /////////////////////////////////////////
    //coursesscene
    @FXML
    private Button courseform_btn;
    @FXML
    private AnchorPane courses_form;
    @FXML
    private TableView<DTO_courses> courses_tabel_view;
    @FXML
    private TableColumn<DTO_courses, Integer> course_id;
    @FXML
    private TableColumn<DTO_courses, String> course_name;
    @FXML
    private TableColumn<DTO_courses, String> course_describtion;
    @FXML
    private TableColumn<DTO_courses, String> credit_hours;
    @FXML
    private TableColumn<DTO_courses, Integer> instractor_id;
    @FXML
    private TextField TFC_course_id;
    @FXML
    private TextField TFC_course_name;
    @FXML
    private TextField TFC_course_describtion;
    @FXML
    private Button C_addbtn;
    @FXML
    private Button c_updatebtn;
    @FXML
    private Button C_deletebtn;
    @FXML
    private Button C_crearbtn;
    @FXML
    private TextField TFC_credit_hours;
    @FXML
    private TextField TFC_instractor_id;

    public ObservableList<DTO_courses> addcoursesListData() {
        ObservableList<DTO_courses> listcourses = FXCollections.observableArrayList();
        String sql = "select * from courses";
        try {
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/university_case_study", "root", "yousefsaber_1999");
            DTO_courses courses;
            PreparedStatement prepare = connect.prepareStatement(sql);

            ResultSet result = prepare.executeQuery();
            while (result.next()) {
                courses = new DTO_courses(
                        result.getInt("course_id"),
                        result.getString("course_name"),
                        result.getString("course_description"),
                        result.getString("credit_hours"),
                        result.getInt("instractor_id"));
                listcourses.add(courses);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listcourses;
    }

    private ObservableList<DTO_courses> addcoursesListD;

    private void addcoursesShowListData() {
        addcoursesListD = addcoursesListData();
        course_id.setCellValueFactory(new PropertyValueFactory<>("course_id"));
        course_name.setCellValueFactory(new PropertyValueFactory<>("course_name"));
        course_describtion.setCellValueFactory(new PropertyValueFactory<>("course_describtion"));
        credit_hours.setCellValueFactory(new PropertyValueFactory<>("credit_hours"));
        instractor_id.setCellValueFactory(new PropertyValueFactory<>("instractor_id"));
        courses_tabel_view.setItems(addcoursesListD);
    }

    @FXML
    private void loadcourses(ActionEvent event) {
        students_form.setVisible(false);
        courses_form.setVisible(true);
        gpa_form.setVisible(false);
        departement_form.setVisible(false);
        instractors_form.setVisible(false);
        enroll_form.setVisible(false);
        test_form.setVisible(false);

        addcoursesShowListData();
    }

    @FXML
    private void courseview_addaction(ActionEvent event) {
        try {
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/university_case_study", "root", "yousefsaber_1999");
            if (TFC_course_id.getText().isEmpty() || TFC_course_name.getText().isEmpty() || TFC_credit_hours.getText().isEmpty() || TFC_instractor_id.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else {
                String checkData = "SELECT course_id FROM courses WHERE course_id = ?";
                PreparedStatement checkStatement = connect.prepareStatement(checkData);
                checkStatement.setString(1, TFC_course_id.getText());
                ResultSet result = checkStatement.executeQuery();
                if (result.next()) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Student #" + TFC_course_id.getText() + " already exists!");
                    alert.showAndWait();
                } else {
                    String insertData = "INSERT INTO courses (course_id, course_name, course_description, credit_hours, instractor_id) VALUES (?, ?, ?, ?, ?)";
                    PreparedStatement prepare = connect.prepareStatement(insertData);
                    prepare.setString(1, TFC_course_id.getText());
                    prepare.setString(2, TFC_course_name.getText());
                    prepare.setString(3, TFC_course_describtion.getText());
                    prepare.setString(4, TFC_credit_hours.getText());
                    prepare.setString(5, TFC_instractor_id.getText());
                    prepare.executeUpdate();
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("coursrs added successfully!");
                    alert.showAndWait();
                    addcoursesShowListData();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("An error occurred while adding the course!");
            alert.showAndWait();
        }
    }

    @FXML
    private void courseview_updateaction(ActionEvent event) throws SQLException {

        StringBuilder updateBuilder = new StringBuilder("UPDATE courses SET ");

    if (!TFC_course_name.getText().isEmpty()) {
        updateBuilder.append("course_name = '").append(TFC_course_name.getText()).append("', ");
    }

    if (!TFC_course_describtion.getText().isEmpty()) {
        updateBuilder.append("course_description = '").append(TFC_course_describtion.getText()).append("', ");
    }

    if (!TFC_credit_hours.getText().isEmpty()) {
        updateBuilder.append("credit_hours = '").append(TFC_credit_hours.getText()).append("', ");
    }

    if (!TFC_instractor_id.getText().isEmpty()) {
        updateBuilder.append("instractor_id = ").append(Integer.parseInt(TFC_instractor_id.getText())).append(", ");
    }

    updateBuilder.deleteCharAt(updateBuilder.length() - 2);

    updateBuilder.append(" WHERE course_id = ").append(Integer.parseInt(TFC_course_id.getText()));

    String update = updateBuilder.toString();

        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/university_case_study", "root", "yousefsaber_1999");
        Alert alert;
        if (TFC_course_id.getText().isEmpty()) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();
        } else {
            alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to UPDATE course #" + TFC_course_id.getText() + "?");
            Optional<ButtonType> option = alert.showAndWait();
            if (option.get().equals(ButtonType.OK)) {
                Statement statement = connect.createStatement();
                statement.executeUpdate(update);

                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully Updated!");
                alert.showAndWait();
                addcoursesShowListData();

            }
        }
    }

    @FXML
    private void courseview_clearaction(ActionEvent event) {
        TFC_course_id.clear();
        TFC_course_name.clear();
        TFC_course_describtion.clear();
        TFC_credit_hours.clear();
        TFC_instractor_id.clear();
    }

    @FXML
    private void courseview_deleteaction(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to delete course #" + TFC_course_id.getText() + "?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            try {
                String deletec = "DELETE FROM courses WHERE course_id = ?";
                String deletee = "DELETE FROM enroll WHERE course_id = ?";
                String delete = "DELETE FROM test WHERE course_id = ?";
                Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/university_case_study", "root", "yousefsaber_1999");
                PreparedStatement statement1 = connect.prepareStatement(delete);
                PreparedStatement statement2 = connect.prepareStatement(deletee);
                PreparedStatement statement3 = connect.prepareStatement(deletec);
                statement1.setInt(1, Integer.parseInt(TFC_course_id.getText()));
                statement2.setInt(1, Integer.parseInt(TFC_course_id.getText()));
                statement3.setInt(1, Integer.parseInt(TFC_course_id.getText()));

                statement1.executeUpdate();
                statement2.executeUpdate();
                int rowsAffected = statement3.executeUpdate();

                if (rowsAffected > 0) {
                    Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                    successAlert.setTitle("Success");
                    successAlert.setHeaderText(null);
                    successAlert.setContentText("course #" + TFC_course_id.getText() + " deleted successfully.");
                    successAlert.showAndWait();
                    addcoursesShowListData();
                    
                    
                } else {
                    Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                    errorAlert.setTitle("Error");
                    errorAlert.setHeaderText(null);
                    errorAlert.setContentText("Failed to delete course #" + TFC_course_id.getText() + ".");
                    errorAlert.showAndWait();
                }
            } catch (SQLException ex) {
                Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /////////////////////////////////////////
    //departmentscene
    @FXML
    private Button deptform_btn;
    @FXML
    private AnchorPane departement_form;
    @FXML
    private TableView<DTO_departments> dept_tabel_view;
    @FXML
    private TableColumn<DTO_departments, Integer> departments_id;
    @FXML
    private TableColumn<DTO_departments, String> department_name;
    @FXML
    private TableColumn<DTO_departments, String> department_desc;
    @FXML
    private Label deptview_dept_id_label;
    @FXML
    private TextField TFD_department_name;
    @FXML
    private Label deptview_dept_name_label;
    @FXML
    private TextField TFD_departments_id;
    @FXML
    private Button D_insertbtn;
    @FXML
    private Button d_updatebtn;
    @FXML
    private Button D_deletebtn;
    @FXML
    private Button D_crearbtn;
    @FXML
    private Label deptview_dept_id_label1;
    @FXML
    private TextField TFD_department_desc;

    public ObservableList<DTO_departments> adddepartmentsListData() {
        ObservableList<DTO_departments> listdepartments = FXCollections.observableArrayList();
        String sql = "select * from departments";
        try {
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/university_case_study", "root", "yousefsaber_1999");
            DTO_departments departments;
            PreparedStatement prepare = connect.prepareStatement(sql);
            ResultSet result = prepare.executeQuery();
            while (result.next()) {
                departments = new DTO_departments(
                        result.getInt("departments_id"),
                        result.getString("department_name"),
                        result.getString("department_desc"));
                listdepartments.add(departments);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listdepartments;
    }

    private ObservableList<DTO_departments> adddepartmentsList;

    private void adddepartmentsShowListData() {
        adddepartmentsList = adddepartmentsListData();
        departments_id.setCellValueFactory(new PropertyValueFactory<>("departments_id"));
        department_name.setCellValueFactory(new PropertyValueFactory<>("department_name"));
        department_desc.setCellValueFactory(new PropertyValueFactory<>("departmnt_desc"));
        dept_tabel_view.setItems(adddepartmentsList);
    }

    @FXML
    private void loaddept(ActionEvent event) {
        students_form.setVisible(false);
        courses_form.setVisible(false);
        gpa_form.setVisible(false);
        departement_form.setVisible(true);
        instractors_form.setVisible(false);
        enroll_form.setVisible(false);
        test_form.setVisible(false);

        adddepartmentsShowListData();
    }

    @FXML
    private void deptview_addaction(ActionEvent event) {
        try {
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/university_case_study", "root", "yousefsaber_1999");
            if (TFD_departments_id.getText().isEmpty() || TFD_department_name.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else {
                String checkData = "SELECT departments_id FROM departments WHERE departments_id = ?";
                PreparedStatement checkStatement = connect.prepareStatement(checkData);
                checkStatement.setString(1, TFD_departments_id.getText());
                ResultSet result = checkStatement.executeQuery();
                if (result.next()) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Student #" + TFD_departments_id.getText() + " already exists!");
                    alert.showAndWait();
                } else {
                    String insertData = "INSERT INTO departments (departments_id, department_name, department_desc) VALUES (?, ?, ?)";
                    PreparedStatement prepare = connect.prepareStatement(insertData);
                    prepare.setString(1, TFD_departments_id.getText());
                    prepare.setString(2, TFD_department_name.getText());
                    prepare.setString(3, TFD_department_desc.getText());
                    prepare.executeUpdate();
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("department added successfully!");
                    alert.showAndWait();
                    adddepartmentsShowListData();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("An error occurred while adding the department!");
            alert.showAndWait();
        }
    }

    @FXML
    private void deptview_updateaction(ActionEvent event) throws SQLException {

        String update = "UPDATE departments SET "
                + "department_name = '" + TFD_department_name.getText() + "'"
                + ", department_desc = '" + TFD_department_desc.getText() + "'"
                + " WHERE departments_id = "
                + Integer.parseInt(TFD_departments_id.getText());

        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/university_case_study", "root", "yousefsaber_1999");
        Alert alert;
        if (TFD_departments_id.getText().isEmpty()
                || TFD_department_name.getText().isEmpty()
                || TFD_department_desc.getText() == null) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();
        } else {
            alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to UPDATE department #" + TFD_departments_id.getText() + "?");
            Optional<ButtonType> option = alert.showAndWait();
            if (option.get().equals(ButtonType.OK)) {
                Statement statement = connect.createStatement();
                statement.executeUpdate(update);

                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully Updated!");
                alert.showAndWait();
                adddepartmentsShowListData();

            }
        }
    }

    @FXML
    private void deptview_clearaction(ActionEvent event) {
        TFD_departments_id.clear();
        TFD_department_name.clear();
        TFD_department_desc.clear();
    }

    @FXML
    private void deptview_deleteaction(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to delete department #" + TFD_departments_id.getText() + "?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            try {
                String delete = "DELETE FROM departments WHERE departments_id = ?";
                Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/university_case_study", "root", "yousefsaber_1999");
                PreparedStatement statement = connect.prepareStatement(delete);
                statement.setInt(1, Integer.parseInt(TFD_departments_id.getText()));
                int rowsAffected = statement.executeUpdate();

                if (rowsAffected > 0) {
                    Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                    successAlert.setTitle("Success");
                    successAlert.setHeaderText(null);
                    successAlert.setContentText("course #" + TFD_departments_id.getText() + " deleted successfully.");
                    successAlert.showAndWait();
                    adddepartmentsShowListData();
                } else {
                    Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                    errorAlert.setTitle("Error");
                    errorAlert.setHeaderText(null);
                    errorAlert.setContentText("Failed to delete department #" + TFD_departments_id.getText() + ".");
                    errorAlert.showAndWait();
                }
            } catch (SQLException ex) {
                Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private Button gpa_btn;
    @FXML
    private AnchorPane gpa_form;
    @FXML
    private TableColumn<DTO_students, Integer> R_student_id;
    @FXML
    private TableColumn<DTO_students, Double> R_GPA;
    @FXML
    private TableView<DTO_students> student_gpa_table;
    @FXML
    private TableView<DTO_courses> case1;
    @FXML
    private TableColumn<DTO_courses, Integer> R_course_id;
    @FXML
    private TableColumn<DTO_courses, Integer> R_number_of_students;
    @FXML
    private TableColumn<DTO_courses, Double> R_Average_GPA;

    public ObservableList<DTO_students> adddstudentssListData() {
        ObservableList<DTO_students> liststudents = FXCollections.observableArrayList();
        String sql = "select student_id,GPA from students";
        try {
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/university_case_study", "root", "yousefsaber_1999");
            DTO_students studentss;
            PreparedStatement prepare = connect.prepareStatement(sql);
            ResultSet result = prepare.executeQuery();
            while (result.next()) {
                studentss = new DTO_students(
                        result.getInt("student_id"),
                        result.getDouble("GPA"));
                liststudents.add(studentss);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return liststudents;
    }

    private ObservableList<DTO_students> addstudentssList;

    private void addstudentssShowListData() {
        addstudentssList = adddstudentssListData();
        R_student_id.setCellValueFactory(new PropertyValueFactory<>("student_id"));
        R_GPA.setCellValueFactory(new PropertyValueFactory<>("GPA"));
        student_gpa_table.setItems(addstudentssList);
    }

    public void populateGpaTable() {
        ObservableList<DTO_courses> gpaData = FXCollections.observableArrayList();

        String sql = " SELECT \n" +
"    e.course_id,\n" +
"    COUNT(DISTINCT e.student_id) AS num_students_enrolled,\n" +
"    AVG(g.grade) AS average_grade\n" +
"FROM \n" +
"    enroll e\n" +
"JOIN \n" +
"    test t ON e.student_id = t.student_id AND e.course_id = t.course_id\n" +
"JOIN \n" +
"    grades g ON t.grade_code = g.grade_code\n" +
"GROUP BY \n" +
"    e.course_id;";

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/university_case_study", "root", "yousefsaber_1999");
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int courseId = resultSet.getInt("course_id");
                int numStudents = resultSet.getInt("num_students_enrolled");
                double avgGpa = resultSet.getDouble("average_grade");

                DTO_courses courseData = new DTO_courses(courseId, numStudents, avgGpa);
                gpaData.add(courseData);
            }

            R_course_id.setCellValueFactory(new PropertyValueFactory<>("course_id"));
            R_number_of_students.setCellValueFactory(new PropertyValueFactory<>("numStudents"));
            R_Average_GPA.setCellValueFactory(new PropertyValueFactory<>("avgGpa"));

            case1.setItems(gpaData);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
       
    }
    

    @FXML
    private void loadgpa(ActionEvent event) {
        students_form.setVisible(false);
        courses_form.setVisible(false);
        gpa_form.setVisible(true);
        departement_form.setVisible(false);
        instractors_form.setVisible(false);
        enroll_form.setVisible(false);
        test_form.setVisible(false);
    
        addstudentssShowListData();
        populateGpaTable();
    }
    
    
    ////////////////////////////////
    ////instractor_name
    @FXML
    private AnchorPane instractors_form;
    @FXML
    private Button instractorsform_btn;
    @FXML
    private TableView<DTO_instractors> courses_tabel_view1;
    @FXML
    private TableColumn<DTO_instractors, Integer> instractoor_id;
    @FXML
    private TableColumn<DTO_instractors, String> instractor_name;
    @FXML
    private TableColumn<DTO_instractors, Integer> department_id;
    @FXML
    private TextField TFi_instractor_id;
    @FXML
    private TextField TFi_instractor_name;
    @FXML
    private Button i_addbtn;
    @FXML
    private Button i_updatebtn;
    @FXML
    private Button i_deletebtn;
    @FXML
    private Button i_crearbtn;
    @FXML
    private TextField TFi_department_id;
    
    
    public ObservableList<DTO_instractors> addinstractorsListData() {
        ObservableList<DTO_instractors> listinstractors = FXCollections.observableArrayList();
        String sql = "select * from instractor";
        try {
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/university_case_study", "root", "yousefsaber_1999");
            DTO_instractors instractors;
            PreparedStatement prepare = connect.prepareStatement(sql);
            ResultSet result = prepare.executeQuery();
            while (result.next()) {
                instractors = new DTO_instractors(
                        result.getInt("instractor_id"),
                        result.getString("instractor_name"),
                        result.getInt("departments_id"));
                listinstractors.add(instractors);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listinstractors;
    }

    private ObservableList<DTO_instractors> adddinstractorsList;

    private void addinstractorsShowListData() {
        adddinstractorsList = addinstractorsListData();
        instractoor_id.setCellValueFactory(new PropertyValueFactory<>("instractor_id"));
        instractor_name.setCellValueFactory(new PropertyValueFactory<>("instractor_name"));
        department_id.setCellValueFactory(new PropertyValueFactory<>("department_id"));
        courses_tabel_view1.setItems(adddinstractorsList);
    }

    @FXML
    private void loadinstractors(ActionEvent event) {
        students_form.setVisible(false);
        courses_form.setVisible(false);
        gpa_form.setVisible(false);
        departement_form.setVisible(false);
        instractors_form.setVisible(true);
        enroll_form.setVisible(false);
        test_form.setVisible(false);

        addinstractorsShowListData();
    }

    @FXML
    private void instractorview_addaction(ActionEvent event) {
        try {
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/university_case_study", "root", "yousefsaber_1999");
            if (TFi_instractor_id.getText().isEmpty() || TFi_instractor_name.getText().isEmpty()  || TFi_department_id.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else {
                String checkData = "SELECT instractor_id FROM instractor WHERE instractor_id = ?";
                PreparedStatement checkStatement = connect.prepareStatement(checkData);
                checkStatement.setString(1, instractor_id.getText());
                ResultSet result = checkStatement.executeQuery();
                if (result.next()) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Student #" + instractor_id.getText() + " already exists!");
                    alert.showAndWait();
                } else {
                    String insertData = "INSERT INTO instractor (instractor_id, instractor_name, departments_id) VALUES (?, ?, ?)";
                    PreparedStatement prepare = connect.prepareStatement(insertData);
                    prepare.setString(1, TFi_instractor_id.getText());
                    prepare.setString(2, TFi_instractor_name.getText());
                    prepare.setString(3, TFi_department_id.getText());
                    prepare.executeUpdate();
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("instractor added successfully!");
                    alert.showAndWait();
                    addinstractorsShowListData();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("An error occurred while adding the instractor!");
            alert.showAndWait();
        }
    }

    @FXML
    private void instractorview_updateaction(ActionEvent event) throws SQLException {

        String update = "UPDATE instractor SET "
                + "instractor_name = '" + TFi_instractor_name.getText() + "'"
                + ", departments_id = " + TFi_department_id.getText()
                + " WHERE instractor_id = "
                + Integer.parseInt(TFi_instractor_id.getText());

        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/university_case_study", "root", "yousefsaber_1999");
        Alert alert;
        if (TFi_instractor_id.getText().isEmpty()) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();
        } else {
            alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to UPDATE instractor #" + TFi_instractor_id.getText() + "?");
            Optional<ButtonType> option = alert.showAndWait();
            if (option.get().equals(ButtonType.OK)) {
                Statement statement = connect.createStatement();
                statement.executeUpdate(update);

                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully Updated!");
                alert.showAndWait();
                addinstractorsShowListData();

            }
        }
    }

    @FXML
    private void instractorview_clearaction(ActionEvent event) {
        TFi_instractor_id.clear();
        TFi_instractor_name.clear();
        TFi_department_id.clear();
    }

    @FXML
    private void instractorview_deleteaction(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to delete instractor #" + TFi_instractor_id.getText() + "?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            try {
                String delete = "DELETE FROM instractor WHERE instractor_id = ?";
                String deletee = "DELETE FROM courses WHERE course_id = ?";
                Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/university_case_study", "root", "yousefsaber_1999");
                PreparedStatement statement1 = connect.prepareStatement(deletee);
                PreparedStatement statement2 = connect.prepareStatement(delete);
                
                statement1.setInt(1, Integer.parseInt(TFi_instractor_id.getText()));
                statement2.setInt(1, Integer.parseInt(TFi_instractor_id.getText()));
                
                statement1.executeUpdate();
                int rowsAffected = statement2.executeUpdate();

                if (rowsAffected > 0) {
                    Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                    successAlert.setTitle("Success");
                    successAlert.setHeaderText(null);
                    successAlert.setContentText("course #" + TFi_instractor_id.getText() + " deleted successfully.");
                    successAlert.showAndWait();
                    addinstractorsShowListData();
                } else {
                    Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                    errorAlert.setTitle("Error");
                    errorAlert.setHeaderText(null);
                    errorAlert.setContentText("Failed to delete instractor #" + TFi_instractor_id.getText() + ".");
                    errorAlert.showAndWait();
                }
            } catch (SQLException ex) {
                Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
/////////////////////////////////////////
    //////////////
    @FXML
    private Button logoutbtn;
    @FXML
    private void logout(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /////////////////////////////////
    /////////enrollscene
    
    @FXML
    private Button enrollbtn;
   @FXML
    private TableView<DTO_enroll> enroll_table;
    @FXML
    private AnchorPane enroll_form;
    @FXML
    private TableColumn<DTO_enroll, Integer> e_student_id;
    @FXML
    private TableColumn<DTO_enroll, Integer> e_course_id;
    @FXML
    private Button e_add_btn;
    @FXML
    private Button e_clare_btn;
    @FXML
    private Button e_delete_btn;
    @FXML
    private TextField tfe_student_id;
    @FXML
    private TextField tfe_course_id;

    
    public ObservableList<DTO_enroll> addenrollListData() {
        ObservableList<DTO_enroll> listenroll = FXCollections.observableArrayList();
        String sql = "select * from enroll";
        try {
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/university_case_study", "root", "yousefsaber_1999");
            DTO_enroll enroll;
            PreparedStatement prepare = connect.prepareStatement(sql);
            ResultSet result = prepare.executeQuery();
            while (result.next()) {
                enroll = new DTO_enroll(
                        result.getInt("student_id"),
                        result.getInt("course_id"));
                listenroll.add(enroll);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listenroll;
    }

    private ObservableList<DTO_enroll> adddenrollList;

    private void addenrollShowListData() {
    adddenrollList = addenrollListData(); 
    e_student_id.setCellValueFactory(new PropertyValueFactory<>("student_id"));
    e_course_id.setCellValueFactory(new PropertyValueFactory<>("course_id"));
    enroll_table.setItems(adddenrollList);
    }

    @FXML
    private void loadenroll(ActionEvent event) {
        students_form.setVisible(false);
        courses_form.setVisible(false);
        gpa_form.setVisible(false);
        departement_form.setVisible(false);
        instractors_form.setVisible(false);
        enroll_form.setVisible(true);
        test_form.setVisible(false);

        addenrollShowListData();
    }

    @FXML
    private void enrollview_addaction(ActionEvent event) {
        try {
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/university_case_study", "root", "yousefsaber_1999");
            if (tfe_student_id.getText().isEmpty() || tfe_course_id.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else {
                String checkData = "SELECT student_id FROM enroll WHERE student_id = ?";
                PreparedStatement checkStatement = connect.prepareStatement(checkData);
                checkStatement.setString(1, student_id.getText());
                ResultSet result = checkStatement.executeQuery();
                if (result.next()) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Student #" + student_id.getText() + " already exists!");
                    alert.showAndWait();
                } else {
                    String insertData = "INSERT INTO enroll (student_id, course_id) VALUES (?, ?)";
                    PreparedStatement prepare = connect.prepareStatement(insertData);
                    prepare.setString(1, tfe_student_id.getText());
                    prepare.setString(2, tfe_course_id.getText());
                    prepare.executeUpdate();
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("enrollment added successfully!");
                    alert.showAndWait();
                    addenrollShowListData();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("An error occurred while adding the enroll!");
            alert.showAndWait();
        }
    }

    @FXML
    private void enrollview_clearaction(ActionEvent event) {
        tfe_student_id.clear();
        tfe_course_id.clear();
    }

    @FXML
private void enrollview_deleteaction(ActionEvent event) {
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setTitle("Confirmation");
    alert.setHeaderText(null);
    alert.setContentText("Are you sure you want to delete enrollment #" + tfe_student_id.getText() + " " + tfe_course_id.getText() + "?");

    Optional<ButtonType> result = alert.showAndWait();
    if (result.isPresent() && result.get() == ButtonType.OK) {
        try {
            String delete = "DELETE FROM enroll WHERE student_id = ? AND course_id = ?";

            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/university_case_study", "root", "yousefsaber_1999");
            PreparedStatement statement = connect.prepareStatement(delete);

            statement.setInt(1, Integer.parseInt(tfe_student_id.getText()));
            statement.setInt(2, Integer.parseInt(tfe_course_id.getText()));

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                successAlert.setTitle("Success");
                successAlert.setHeaderText(null);
                successAlert.setContentText("Enrollment #" + tfe_student_id.getText() + " " + tfe_course_id.getText() + " deleted successfully.");
                successAlert.showAndWait();
                addenrollShowListData();

                
            } else {
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setTitle("Error");
                errorAlert.setHeaderText(null);
                errorAlert.setContentText("Failed to delete enrollment #" + tfe_student_id.getText() + " " + tfe_course_id.getText() + ".");
                errorAlert.showAndWait();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("An error occurred while deleting the enrollment!");
            alert.showAndWait();
        }
    }
}

    
    
    @FXML
    private Button gradebtn;
    @FXML
    private AnchorPane test_form;
    @FXML
    private TableView<DTO_test> test_table;
    @FXML
    private TableColumn<DTO_test, Integer> t_student_id;
    @FXML
    private TableColumn<DTO_test, Integer> t_course_id;
    @FXML
    private TableColumn<DTO_test, String> t_grade_code;
    @FXML
    private TableColumn<DTO_test, String> t_date;
    @FXML
    private Button t_addbtn;
    @FXML
    private Button t_deletebtn;
    @FXML
    private Button t_clearbtn;
    @FXML
    private TextField tft_student_id;
    @FXML
    private TextField tft_course_id;
    @FXML
    private TextField tft_date;
    @FXML
    private TextField tft_grade_code;
    
    public ObservableList<DTO_test> addtestListData() {
        ObservableList<DTO_test> listtest = FXCollections.observableArrayList();
        String sql = "select * from test";
        try {
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/university_case_study", "root", "yousefsaber_1999");
            DTO_test test;
            PreparedStatement prepare = connect.prepareStatement(sql);
            ResultSet result = prepare.executeQuery();
            while (result.next()) {
                test = new DTO_test(
                        result.getInt("student_id"),
                        result.getInt("course_id"),
                        result.getString("grade_code"),
                        result.getString("date"));
                listtest.add(test);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listtest;
    }

    private ObservableList<DTO_test> addtestList;

    private void addtestShowListData() {
    addtestList = addtestListData(); 
    t_student_id.setCellValueFactory(new PropertyValueFactory<>("student_id"));
    t_course_id.setCellValueFactory(new PropertyValueFactory<>("course_id"));
    t_grade_code.setCellValueFactory(new PropertyValueFactory<>("grade_code"));
    t_date.setCellValueFactory(new PropertyValueFactory<>("date"));
    test_table.setItems(addtestList); 
    }
    
    
      @FXML
    private void loadgrades(ActionEvent event) {
        students_form.setVisible(false);
        courses_form.setVisible(false);
        gpa_form.setVisible(false);
        departement_form.setVisible(false);
        instractors_form.setVisible(false);
        enroll_form.setVisible(false);
        test_form.setVisible(true);
        addtestShowListData();
    }
    
    
   @FXML
    private void testview_addaction(ActionEvent event) {
        try {
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/university_case_study", "root", "yousefsaber_1999");
            if (tft_student_id.getText().isEmpty() || tft_course_id.getText().isEmpty() || tft_grade_code.getText().isEmpty()|| tft_date.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else {
                String checkData = "SELECT student_id,course_id,date FROM test WHERE student_id = ? and course_id = ? and date =?";
                PreparedStatement checkStatement = connect.prepareStatement(checkData);
                checkStatement.setString(1, tft_student_id.getText());
                checkStatement.setString(2, tft_course_id.getText());
                checkStatement.setString(3, tft_date.getText());
                ResultSet result = checkStatement.executeQuery();
                if (result.next()) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Test result for student #" + tft_student_id.getText() + " on course #" + tft_course_id.getText() + " already exists!");
                    alert.showAndWait();
                } else {
                    String insertData = "INSERT INTO test (student_id, course_id, grade_code, date) VALUES (?, ?, ?, ?)";
                    PreparedStatement prepare = connect.prepareStatement(insertData);
                    prepare.setInt(1, Integer.parseInt(tft_student_id.getText())); 
                    prepare.setInt(2, Integer.parseInt(tft_course_id.getText())); 
                    prepare.setString(3, tft_grade_code.getText());
                    prepare.setString(4, tft_date.getText());
                    prepare.executeUpdate();
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("test result added successfully!");
                    alert.showAndWait();
                    addtestShowListData();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("An error occurred while adding the test result!");
            alert.showAndWait();
        }
    }
    @FXML
    private void testview_clearaction(ActionEvent event) {
        tft_student_id.clear();
        tft_course_id.clear();
        tft_grade_code.clear();
        tft_date.clear();

    }
    @FXML
    private void testview_deleteaction(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setTitle("Confirmation");
    alert.setHeaderText(null);
    alert.setContentText("Are you sure you want to delete test result #" + tft_student_id.getText() + " " + tft_course_id.getText() + "?");

    Optional<ButtonType> result = alert.showAndWait();
    if (result.isPresent() && result.get() == ButtonType.OK) {
        try {
            String delete = "DELETE FROM test WHERE student_id = ? AND course_id = ? and date = ?";

            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/university_case_study", "root", "yousefsaber_1999");
            PreparedStatement statement = connect.prepareStatement(delete);

            statement.setInt(1, Integer.parseInt(tft_student_id.getText()));
            statement.setInt(2, Integer.parseInt(tft_course_id.getText()));
            statement.setString(3,(tft_date.getText()));

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                successAlert.setTitle("Success");
                successAlert.setHeaderText(null);
                successAlert.setContentText("test result #" + tft_student_id.getText() + " " + tft_course_id.getText() +  " deleted successfully.");
                successAlert.showAndWait();
                // Add any necessary code here to update your view after deleting the enrollment
            } else {
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setTitle("Error");
                errorAlert.setHeaderText(null);
                errorAlert.setContentText("Failed to delete test result #" + tft_student_id.getText() + " " + tft_course_id.getText() + ".");
                errorAlert.showAndWait();
                addtestShowListData();

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("An error occurred while deleting the enrollment!");
            alert.showAndWait();
        }
    }    
  }  
}