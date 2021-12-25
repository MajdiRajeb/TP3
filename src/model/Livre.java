package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

    @Entity
        public class Livre implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        private String titre;

        public Livre(String titre) {
            this.titre = titre;
        }

        public String getTitre() {
            return titre;
        }

        public void setTitre(String titre) {
            this.titre = titre;
        }

        public Livre(int id) {
            this.id = id;
        }

        public Livre() {

        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }



