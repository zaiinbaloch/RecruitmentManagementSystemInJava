package recruitmentmanagement;

class Menus {
     void Adminmenu() {
        System.out.println("\n--- Admin Menu ---");
        System.out.println("Enter 1 to create, update or delete job");
        System.out.println("Enter 2 to create, update or delete Applicant");
        System.out.println("Enter 3 to Logout");
    }
    
    void jobmenu() {
        System.out.println("\n--- Job Menu ---");
        System.out.println("Enter 1 to add Job details");
        System.out.println("Enter 2 to view Job details");
        System.out.println("Enter 3 to update Job details");
        System.out.println("Enter 4 to delete Job details");    
    }
    void applicantmenu() {
        System.out.println("\n--- Applicant Menu ---");
        System.out.println("Enter 1 to add Applicant details");
        System.out.println("Enter 2 to view Applicant details");
        System.out.println("Enter 3 to update Applicant details");
        System.out.println("Enter 4 to delete Applicant details");
    }
    void stakeholders(){
        System.out.println("\n--- Recruitment Managemant System Menu ---");
        System.out.println("Enter 1 if you want to login as Admin");
        System.out.println("Enter 2 if you want to login as HR");
        System.out.println("Enter 3 if you want to login as Hiring Department");
        System.out.println("Enter 4 to Shut down the System");
        
    }
    void HRmenu(){
        System.out.println("\n--- HR Menu ---");
        System.out.println("Enter 1 to View Applicants");
        System.out.println("Enter 2 to select for Interviews");
        System.out.println("Enter 3 to Display HR Team Name");
        System.out.println("Enter 4 to Logout");
    }
    
    void HiringDepartmentmenu(){
        System.out.println("\n--- Hiring Department Menu ---");
        System.out.println("Enter 1 to View Applicants");
        System.out.println("Enter 2 to update status after Interviews");
        System.out.println("Enter 3 to Logout");
    }
}