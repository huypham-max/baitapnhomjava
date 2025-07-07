import model.Consultant;
import model.Degree;
import model.Experience;
import model.Feedback;

public class Main {
    public static void main(String[] args) {
        Consultant consultant = new Consultant(1, "Nguyễn Văn A", "a@gmail.com", "0901234567");
        consultant.addDegree(new Degree("Cử nhân Tâm lý", "ĐH KHXH&NV", 2018));
        consultant.addExperience(new Experience("Công ty ABC", "Tư vấn viên", 3));
        consultant.addFeedback(new Feedback("Khách hàng 1", 5, "Rất nhiệt tình!"));
        consultant.addFeedback(new Feedback("Khách hàng 2", 4, "Hài lòng với buổi tư vấn"));

        System.out.println(consultant);
    }
}
