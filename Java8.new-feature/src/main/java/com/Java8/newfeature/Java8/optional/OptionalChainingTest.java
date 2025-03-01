package com.Java8.newfeature.Java8.optional;

import java.util.Optional;

public class OptionalChainingTest {
    // DTO classes same as before
    static class ObjectADTO {
        private ObjectBDTO objectB;
        public ObjectBDTO getObjectB() {
            System.out.println("Calling DTO getObjectB");
            return objectB;
        }
        public void setObjectB(ObjectBDTO objectB) {
            this.objectB = objectB;
        }
    }

    static class ObjectBDTO {
        private ItemDTO item;
        public ItemDTO getItem() {
            System.out.println("Calling DTO getItem");
            return item;
        }
        public void setItem(ItemDTO item) {
            this.item = item;
        }
    }

    static class ItemDTO {
        private String value;
        public String getValue() {
            System.out.println("Calling DTO getValue");
            return value;
        }
        public void setValue(String value) {
            this.value = value;
        }
    }

    // Entity classes same as before
    static class ObjectA {
        private ObjectB objectB;
        public ObjectB getObjectB() {
            System.out.println("Calling Entity getObjectB");
            return objectB;
        }
        public void setObjectB(ObjectB objectB) {
            this.objectB = objectB;
        }

        public ObjectADTO toDTO() {
            ObjectADTO dto = new ObjectADTO();
            if (this.objectB != null) {
                dto.setObjectB(this.objectB.toDTO());
            }
            return dto;
        }
    }

    static class ObjectB {
        private Item item;
        public Item getItem() {
            System.out.println("Calling Entity getItem");
            return item;
        }
        public void setItem(Item item) {
            this.item = item;
        }

        public ObjectBDTO toDTO() {
            ObjectBDTO dto = new ObjectBDTO();
            if (this.item != null) {
                dto.setItem(this.item.toDTO());
            }
            return dto;
        }
    }

    static class Item {
        private String value;
        public String getValue() {
            System.out.println("Calling Entity getValue");
            return value;
        }
        public void setValue(String value) {
            this.value = value;
        }

        public ItemDTO toDTO() {
            ItemDTO dto = new ItemDTO();
            dto.setValue(this.value);
            return dto;
        }
    }

    static class ObjectC {
        public static String getItemValue(ItemDTO item) {
            System.out.println("Calling getItemValue");
            return item.getValue();
        }
    }

    public static void main(String[] args) {
        ObjectA objectA = new ObjectA();

        // Correct way to chain with entities and DTOs
        System.out.println("\nTest 1: Correct chaining with conversion to DTO");
        String result1 = Optional.ofNullable(objectA.getObjectB())
                .map(ObjectB::toDTO)           // Convert ObjectB to ObjectBDTO
                .map(ObjectBDTO::getItem)      // Get ItemDTO
                .map(ObjectC::getItemValue)    // Now correctly passing ItemDTO
                .orElse(null);
        System.out.println("Result: " + result1);

        // Test with complete object chain
        System.out.println("\nTest 2: Complete chain with values");
        ObjectA fullObject = new ObjectA();
        ObjectB objectB = new ObjectB();
        Item item = new Item();
        item.setValue("Hello World");
        objectB.setItem(item);
        fullObject.setObjectB(objectB);

        String result2 = Optional.ofNullable(fullObject.getObjectB())
                .map(ObjectB::toDTO)           // Convert ObjectB to ObjectBDTO
                .map(ObjectBDTO::getItem)      // Get ItemDTO
                .map(ObjectC::getItemValue)    // Now correctly passing ItemDTO
                .orElse(null);
        System.out.println("Result: " + result2);
    }
}