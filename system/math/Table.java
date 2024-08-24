package system.math;

import java.util.*;
import java.util.function.*;

/**
 * A generic class used to represent a single entry of a Map.
 * Has a unique set of individual methods & properties.
 *
 * @author Shadow Kitty
 * @version 1.0
 */
public final class Table<K, V> {
  //Instance Fields
  public K key;
  public V value;


  /**
   * The common table constructor with a <code>key</code> & <code>value</code> pair.
   *
   * @param key   The table's key.
   * @param value The table's value.
   */
  public Table(K key, V value) {
    this.key = key;
    this.value = value;
  }

  /**
   * The default constructor for creating a default table.
   */
  public Table() {
    this(null, null);
  }

  /**
   * Creates an array of default tables with the provided length. Both key & value pairs are null.
   *
   * @param size The size of the array.
   */
  public static Table[] defaultArray(int size) {
    Table[] output = new Table[size];
    for (int i = 0; i < size; i++) {
      output[i] = new Table<>(null, null);
    }
    return output;
  }

  /**
   * Creates an array of default tables with the provided length. Both key & value pairs are null.
   *
   * @param array The array to create a default one from.
   */
  public static Table[] defaultArray(Table[] array) {
    Table[] output = new Table[array.length];
    for (int i = 0; i < array.length; i++) {
      output[i] = new Table<>(array[i].key, null);
    }
    return output;
  }

  /**
   * Creates a <code>LinkedHashMap</code> of the provided array of tables.
   *
   * @param array The array to create a <code>LinkedHashMap</code> from.
   * @apiNote This will override pre-existing duplicate keys with the last encountered one in the iteration.
   */
  public static LinkedHashMap createHashMap(Table[] array) {
    LinkedHashMap outputMap = new LinkedHashMap<>(array.length);
    for (Table table : array) {
      outputMap.put(table.key, table.value);
    }
    return outputMap;
  }

  /**
   * Converts this instance to a string.
   *
   * @return The string representation of this object.
   */
  @Override
  public String toString() {
    return key + " - " + value;
  }

  /**
   * Tests if the provided argument matches either the <code>key</code> or <code>value</code> of this object.
   *
   * @return A boolean indicating if the argument matches the conditions.
   */
  public boolean match(Object KeyOrValue) {
    return KeyOrValue == key || KeyOrValue == value;
  }

  /**
   * Tests if the provided argument matches the <code>key</code> of this object.
   *
   * @param key The key to match against.
   */
  public boolean matchKey(K key) {
    return this.key == key;
  }

  /**
   * Tests if the provided argument matches the <code>value</code> of this object.
   *
   * @param value The value to match against.
   */
  public boolean matchValue(V value) {
    return this.value == value;
  }

  /**
   * Reverses the table so that everything becomes vice versa.
   *
   * @return The reversed table.
   */
  public Table<V, K> reverse() {
    return new Table<>(value, key);
  }

  /**
   * Modifies the entire table with a new Key, Value pair.
   *
   * @param newKey   The new key to set for this table.
   * @param newValue The new value to set for this table.
   */
  public void modify(K newKey, V newValue) {
    this.key = newKey;
    this.value = newValue;
  }
}
