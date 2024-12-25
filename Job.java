package recruitmentmanagement;

import java.io.*;
import java.util.*;

class Job {
    private String jobTitle;
    private String education;
    private int salary;

    public Job(String jobTitle, String education, int salary) {
        this.jobTitle = jobTitle;
        this.education = education;
        this.salary = salary;
    }


    public String getJobTitle() { return jobTitle; }
    public void setJobTitle(String jobTitle) { this.jobTitle = jobTitle; }

    public String getEducation() { return education; }
    public void setEducation(String education) { this.education = education; }

    public int getSalary() { return salary; }
    public void setSalary(int salary) { this.salary = salary; }

    //new job add krny k liye method
    public void addJob() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Job Title: ");
        this.jobTitle = sc.nextLine();
        System.out.print("Enter Required Education: ");
        this.education = sc.nextLine();
        System.out.print("Enter Salary: ");
        this.salary = sc.nextInt();
    }

    //new job file pr write krny k liye method
    public static void writeJobsToFile(List<Job> jobs, String filename) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (Job job : jobs) {
                bw.write(job.getJobTitle() + " | " + job.getEducation() + " | " + job.getSalary());
                bw.newLine();
            }
            System.out.println("Jobs successfully saved to file.");
        } catch (IOException e) {
            System.out.println("Error writing jobs to file: " + e.getMessage());
        }
    }

    // job file sy read krny k liye method
    public static List<Job> readJobsFromFile(String filename) {
        List<Job> jobs = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split("\\|"); // Split by |
                if (fields.length == 3) { // Ensure correct number of fields
                    String jobTitle = fields[0].trim();
                    String education = fields[1].trim();
                    int salary = Integer.parseInt(fields[2].trim());
                    jobs.add(new Job(jobTitle, education, salary));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("No job file found, starting fresh.");
        } catch (IOException e) {
            System.out.println("Error reading jobs from file: " + e.getMessage());
        }
        return jobs;
    }

    // jobs display krny k liye method
    public static void displayJobs(List<Job> jobs) {
        if (jobs.isEmpty()) {
            System.out.println("No jobs available.");
        } else {
            for (int i = 0; i < jobs.size(); i++) {
                System.out.println((i + 1) + ". " + jobs.get(i).toString());
            }
        }
    }

    //job update krny k liye Method
    public static void updateJob(List<Job> jobs) {
        Scanner sc = new Scanner(System.in);
        displayJobs(jobs);
        System.out.print("Enter the number of the job to update: ");
        int index = sc.nextInt() - 1;
        sc.nextLine(); // Consume newline
        if (index >= 0 && index < jobs.size()) {
            Job job = jobs.get(index);
            System.out.print("Enter new Job Title: ");
            job.jobTitle = sc.nextLine();
            System.out.print("Enter new Required Education: ");
            job.education = sc.nextLine();
            System.out.print("Enter new Salary: ");
            job.salary = sc.nextInt();
        } else {
            System.out.println("Invalid job number.");
        }
    }

    //job delete krny k liye method 
    public static void deleteJob(List<Job> jobs) {
        Scanner sc = new Scanner(System.in);
        displayJobs(jobs);
        System.out.print("Enter the number of the job to delete: ");
        int index = sc.nextInt() - 1;
        if (index >= 0 && index < jobs.size()) {
            jobs.remove(index);
            System.out.println("Job deleted successfully.");
        } else {
            System.out.println("Invalid job number.");
        }
    }

    @Override
    public String toString() {
        return "Job Title: " + jobTitle + ", Education: " + education + ", Salary: " + salary;
    }
}
