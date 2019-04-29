package no.oslomet.user;

import no.oslomet.common.StringUtils;

public class UserApplication {

    public static void main(String[] args) {
        StringUtils utils = new StringUtils();
        for (String arg : args) {
            if (utils.isBlank(arg)) {
                System.err.println("Argument is empty");
            }
        }
    }
}
