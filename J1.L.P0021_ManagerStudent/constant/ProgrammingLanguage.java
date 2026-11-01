/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constant;

/**
 *
 * @author Tuan Tran
 */
public enum ProgrammingLanguage {
    JAVA("JAVA"),
    DOT_NET(".NET"),
    C_CPP("C/C++");
    private String language;

    // Constructor
    ProgrammingLanguage(String language) {
        this.language = language;
    }

    public static ProgrammingLanguage getLanguage(int type) {
        switch (type) {
            case 1:
                return JAVA;
            case 2:
                return DOT_NET;
            case 3:
                return C_CPP;
            default:
                throw new AssertionError();

        }
    }

    public String valueLanguage() {
        return language;
    }
}
