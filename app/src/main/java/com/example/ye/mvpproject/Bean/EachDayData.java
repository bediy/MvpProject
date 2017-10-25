package com.example.ye.mvpproject.Bean;

import java.util.List;

/**
 * Created by Ye on 2017/10/13/0013.
 */

public class EachDayData {

        private List<String> category;
        private boolean error;
        private Results results;
        public void setCategory(List<String> category) {
            this.category = category;
        }
        public List<String> getCategory() {
            return category;
        }

        public void setError(boolean error) {
            this.error = error;
        }
        public boolean getError() {
            return error;
        }

        public void setResults(Results results) {
            this.results = results;
        }
        public Results getResults() {
            return results;
        }

}
