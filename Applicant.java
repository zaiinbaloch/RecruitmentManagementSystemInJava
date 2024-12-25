package recruitmentmanagement;

import java.io.*;
import java.util.*;

class Applicant {
    private int id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String qualifications;
    private String status;

    public Applicant(int id, String name, String email, String phone, String address, String qualifications, String status) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.qualifications = qualifications;
        this.status = status;
    }


    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getQualifications() { return qualifications; }
    public void setQualifications(String qualifications) { this.qualifications = qualifications; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    //applicant ki details display krny k liye Method
    public void displayApplicantDetails() {
        System.out.println("Applicant ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);
        System.out.println("Address: " + address);
        System.out.println("Qualifications: " + qualifications);
        System.out.println("Status: " + status);
    }

  //new applicant ki details add krny k liye Method
    public void addApplicant() {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter Applicant ID: ");
        this.id = s.nextInt();
        s.nextLine(); // Consume newline
        System.out.print("Enter Name: ");
        this.name = s.nextLine();
        System.out.print("Enter Email: ");
        this.email = s.nextLine();
        System.out.print("Enter Phone: ");
        this.phone = s.nextLine();
        System.out.print("Enter Address: ");
        this.address = s.nextLine();
        System.out.print("Enter Qualifications: ");
        this.qualifications = s.nextLine();
        this.status = "Pending"; // status ko by default "Pending" pr set kia hai
    }

    //applicant ki details display update krny k liye Method
    public static void updateApplicant(List<Applicant> applicants) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter Applicant ID to update: ");
        int id = s.nextInt();
        s.nextLine(); 

        for (Applicant applicant : applicants) {
            if (applicant.getId() == id) {
                System.out.println("Updating details for " + applicant.getName());
                System.out.print("Enter New Name: ");
                applicant.setName(s.nextLine());
                System.out.print("Enter New Email: ");
                applicant.setEmail(s.nextLine());
                System.out.print("Enter New Phone: ");
                applicant.setPhone(s.nextLine());
                System.out.print("Enter New Address: ");
                applicant.setAddress(s.nextLine());
                System.out.print("Enter New Qualifications: ");
                applicant.setQualifications(s.nextLine());
                System.out.println("Details updated successfully.");
                break;
            }
        }
    }

  //applicant ki details ki delete krny k liye Method
    public static void deleteApplicant(List<Applicant> applicants) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter Applicant ID to delete: ");
        int id = s.nextInt();
        s.nextLine(); // Consume newline

        applicants.removeIf(applicant -> applicant.getId() == id);
        System.out.println("Applicant with ID " + id + " has been deleted.");
    }

  //sary applicants ki details display krny k liye Method
    public static void displayAllApplicants(List<Applicant> applicants) {
        System.out.println("\n--- All Applicants ---");
        for (Applicant applicant : applicants) {
            applicant.displayApplicantDetails();
            System.out.println("------------------------");
        }
    }

    //Applicants ki details file sy read krny k liye method
    public static List<Applicant> readApplicantsFromFile(String filePath) {
        List<Applicant> applicants = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split("\\|");
                if (fields.length == 7) {
                    int id = Integer.parseInt(fields[0].trim());
                    String name = fields[1].trim();
                    String email = fields[2].trim();
                    String phone = fields[3].trim();
                    String address = fields[4].trim();
                    String qualifications = fields[5].trim();
                    String status = fields[6].trim();
                    applicants.add(new Applicant(id, name, email, phone, address, qualifications, status));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading applicants from file: " + e.getMessage());
        }
        return applicants;
    }

        //Applicants ki details file pr write krny k liye method
    public static void writeApplicantsToFile(List<Applicant> applicants, String filePath) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (Applicant applicant : applicants) {
                bw.write(applicant.getId() + " | " + applicant.getName() + " | " + applicant.getEmail() + " | " +
                        applicant.getPhone() + " | " + applicant.getAddress() + " | " + applicant.getQualifications() + " | " +
                        applicant.getStatus());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing applicants to file: " + e.getMessage());
        }
    }

        //Applicants ka status update krny k liye method
    public static void updateStatus(List<Applicant> applicants, int id, String status) {
        for (Applicant applicant : applicants) {
            if (applicant.getId() == id) {
                applicant.setStatus(status);
                System.out.println("Status for " + applicant.getName() + " updated to " + status);
                break;
            }
        }
    }
}
