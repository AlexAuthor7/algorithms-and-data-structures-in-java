package linearSearch;

/**
 * @Auther: Alex
 * @Date: 2021/1/2 - 01 - 02 -14:41
 * @Description: PACKAGE_NAME
 * @Verxion: 1.0
 */
public class Student {
    String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Student)) {
            return false;
        }
        Student student = (Student) o;
        return this.name.toLowerCase().equals(student.name.toLowerCase());
    }
}
