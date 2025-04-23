public class Pirate_ship_animation {
    public static void main(String[] args) throws InterruptedException {
        String[] waves = {
            "    ~    ~  ~~~      ~~   ~   ~~~ ~     ~ ~",
            " ~~~    ~~  ~   ~~~    ~~ ~   ~~   ~~~~   ~",
            "   ~~   ~~~   ~   ~~  ~    ~~ ~   ~~  ~~~~ ",
            " ~  ~~~~    ~~~    ~    ~~~    ~~  ~     ~ "
        };

        String[] cannons = {
            "                   *      *         *",
            "                                *        *",
            "             *     *",
            "         *            *       *"
        };

        String[][] krakenStages = {
            {
                "",
                "",
                ""
            },
            {
                "                           (  )",
                "",
                ""
            },
            {
                "                           (  )",
                "                           /||\\",
                ""
            },
            {
                "                           (  )",
                "                          /||||\\",
                "                        ~~/||||\\\\~~~"
            },
            {
                "                        ~~(  )~~",
                "                      ~~/||||||\\\\~~~",
                "                    ~~/ |||||||| \\\\~~~~"
            },
            {
                "                      ~~(° ͜ʖ °)~~",
                "                    ~~/||||||||||\\\\~~~",
                "                  ~~/||||||||||||||\\\\~~~"
            }
        };

        int frame = 0;

        while (true) {
           

            // Pirate ship top part
            System.out.println("                          |\\");
            System.out.println("                         /| \\");
            System.out.println("                        /_|__\\");
            System.out.println("                        \\ |  |");
            System.out.println("                         \\|  |");
            System.out.println("                        __|__|__");
            System.out.println("                       |        |");
            System.out.println("                       |  ☠️     |");
            System.out.println("         |    |    |   |________|   |    |    |");
            System.out.println("        )_)  )_)  )_)     ||||     )_)  )_)  )_)");
            System.out.println("       )___))___))___)\\   ||||    )___))___))___)\\");
            System.out.println("      )____)____)_____)\\\\ ||||   )____)____)_____)\\\\");
            System.out.println("    _____|____|____|____\\\\\\|||_____||____|____|_____\\\\\\__");

            // Hull + cannon fire
            System.out.println("----\\          BOOM! 💥      " + cannons[frame % cannons.length] + "   /----");
            System.out.println("     \\_______________________________________________/");

            // Animated Kraken
            System.out.println();
            System.out.println("\n                      " + waves[frame % waves.length]);
            for (String line : krakenStages[Math.min(frame % krakenStages.length, krakenStages.length - 1)]) {
                
                System.out.println("                                                                                  "+line);
            }

            // Waves
           // System.out.println("\n                      " + waves[frame % waves.length]);

            Thread.sleep(700);
            frame++;
        }
    }
}
